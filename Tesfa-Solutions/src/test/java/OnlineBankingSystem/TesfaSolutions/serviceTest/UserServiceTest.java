package OnlineBankingSystem.TesfaSolutions.serviceTest;


import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import OnlineBankingSystem.TesfaSolutions.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

@Before
//// Before each test, set up the mock behavior for userRepository
public void setUp(){
    // Create a mock user
    String userName="emanualla@gmail.com";

    Optional<User> user=Optional.of(new User(userName));

    // Configure userRepository mock to return the mock user when findByUsername is called
    Mockito.when(userRepository.findByUsername(userName))
            .thenReturn(user);
}

@Test
    public  void whenValidEmail(){
    String username="emanualla@gmail.com";
    Optional<User> found=userService.findByUserName(username);
    // If the user is found, assert that their username matches the expected username
    if(found.isPresent())
        assertThat(found.get().getUsername(),equalTo(username));

    else
      // If the user is not found, fail the test with a descriptive message
        fail("User with username " + username + " not found.");
       // assertThat(true,equalTo(false));
}
}
