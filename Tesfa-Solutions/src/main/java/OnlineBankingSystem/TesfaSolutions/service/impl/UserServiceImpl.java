package OnlineBankingSystem.TesfaSolutions.service.impl;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import OnlineBankingSystem.TesfaSolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Override
//    public User getUserByID(int id) {
//        Optional<User> user=repository.findById(id);
//        if(user.isPresent()){
//            return user.get();
//        }else{
//            throw  new RuntimeException("user doesn't exist");
//        }
//
//    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }


}
