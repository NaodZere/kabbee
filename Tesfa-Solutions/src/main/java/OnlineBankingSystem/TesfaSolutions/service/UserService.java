package OnlineBankingSystem.TesfaSolutions.service;

import OnlineBankingSystem.TesfaSolutions.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    public User save(User user);

    public Optional<User> findByUserName(String username);

}
