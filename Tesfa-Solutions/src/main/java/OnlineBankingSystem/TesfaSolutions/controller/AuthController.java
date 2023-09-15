package OnlineBankingSystem.TesfaSolutions.controller;



import OnlineBankingSystem.TesfaSolutions.dto.LoginDTO;
import OnlineBankingSystem.TesfaSolutions.dto.TokenDTO;
import OnlineBankingSystem.TesfaSolutions.dto.UserRegisterDTO;
import OnlineBankingSystem.TesfaSolutions.model.Role;
import OnlineBankingSystem.TesfaSolutions.service.JwtTokenService;
import OnlineBankingSystem.TesfaSolutions.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenService jwtTokenService;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }


//    @PostMapping("/login")
//    public TokenDTO login(@RequestBody LoginDTO dto) {
//        User user = userService.findByUserName(dto.username())
//                .orElseThrow(LoginException::new);
//        if (!passwordEncoder.matches(dto.password(), user.getPassword()))
//           throw new LoginException();
//        return new TokenDTO(jwtTokenService.generateToken(user));
//    }
//
//    private User createUser(UserRegisterDTO dto, Role role) {
//        if (userService.findByUserName(dto.username()).isPresent())
//            throw new UsernameAlreadyExistException();
//        User user = UserRegisterDTO.toUser(dto);
//        user.setPassword(passwordEncoder.encode(dto.password()));
//        user.setRole(role);
//        return userService.save(user);
//    }




}
