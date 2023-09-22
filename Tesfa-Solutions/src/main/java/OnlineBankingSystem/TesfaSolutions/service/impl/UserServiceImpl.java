package OnlineBankingSystem.TesfaSolutions.service.impl;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import OnlineBankingSystem.TesfaSolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> findByUserName(String username) {

        return repository.findByUsername(username);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public ResponseEntity<User> updateUser(int id, User user) {

        Optional<User> existingUserOptional = repository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());

            User updatedUser = repository.save(existingUser);

            // Return the updated user
            return ResponseEntity.ok(updatedUser);
        } else {
            // Handle the case where the user with the given ID doesn't exist
            // Return a 404 Not Found response or an appropriate response for your use case
            return ResponseEntity.notFound().build();
        }
    }




    @Override
    public User getUserByID(int id) {
        Optional<User> user=repository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw  new RuntimeException("user doesn't exist");
        }

    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }


}
