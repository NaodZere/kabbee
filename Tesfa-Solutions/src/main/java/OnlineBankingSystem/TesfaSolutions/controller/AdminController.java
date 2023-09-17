package OnlineBankingSystem.TesfaSolutions.controller;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);


    }
        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser ( @PathVariable int id, @RequestBody User user){
            return userService.updateUser(id, user);

        }


//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserByID(@PathVariable("id") int id){
//        return new ResponseEntity<>(userService.getUserByID(id),HttpStatus.OK );
//    }

        @GetMapping("/all")
        public ResponseEntity<List<User>> findAllUsers () {
            return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);

        }
    }

