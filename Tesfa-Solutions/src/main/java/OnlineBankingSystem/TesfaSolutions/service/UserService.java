package OnlineBankingSystem.TesfaSolutions.service;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> findByUserName(String username) {
        return repository.findByUsername(username);
    }

}
