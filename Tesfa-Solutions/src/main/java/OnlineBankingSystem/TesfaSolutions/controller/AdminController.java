package OnlineBankingSystem.TesfaSolutions.controller;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;

    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        Optional<User> userOptional = userService.findByUserName(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build(); // Return a 404 response if the user is not found
        }
    }


    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
