package OnlineBankingSystem.TesfaSolutions.controller;

import OnlineBankingSystem.TesfaSolutions.dto.LoginDTO;
import OnlineBankingSystem.TesfaSolutions.dto.TokenDTO;
import OnlineBankingSystem.TesfaSolutions.dto.UserDTO;
import OnlineBankingSystem.TesfaSolutions.dto.UserRegisterDTO;
import OnlineBankingSystem.TesfaSolutions.exception.UsernameAlreadyExistException;
import OnlineBankingSystem.TesfaSolutions.model.Role;
import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.service.impl.JwtTokenService;
import OnlineBankingSystem.TesfaSolutions.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenService jwtTokenService;

    public AuthController(UserServiceImpl userService, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }


    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO dto) throws LoginException {
        User user = userService.findByUserName(dto.username())
                .orElseThrow(LoginException::new);
        if (!passwordEncoder.matches(dto.password(), user.getPassword()))
           throw new LoginException();
        return new TokenDTO(jwtTokenService.generateToken(user));
    }

    private User createUser(UserRegisterDTO dto, Role role) {
        if (userService.findByUserName(dto.username()).isPresent())
            throw new UsernameAlreadyExistException();
        User user = UserRegisterDTO.toUser(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(role);
        return userService.save(user);
    }

    @PostMapping("/register/customer")
    public UserDTO registerCustomer(@RequestBody UserRegisterDTO dto) {
        return UserDTO.fromUser(createUser(dto, Role.CUSTOMER));
    }

    @PostMapping("/register/admin")
    public UserDTO registerAdmin(@RequestBody UserRegisterDTO dto) {
        return UserDTO.fromUser(createUser(dto, Role.ADMIN));
    }

    @GetMapping("admin/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        Optional<User> userOptional = userService.findByUserName(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build(); // Return a 404 response if the user is not found
        }
    }



    @ExceptionHandler({RuntimeException.class})
    public String databaseError(RuntimeException exception) {
        return exception.getMessage();
    }


}
