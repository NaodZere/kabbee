package OnlineBankingSystem.TesfaSolutions.repositoryTest;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testUserPersistence(){
        User user= new User("sandu@gmail.com");
        entityManager.persist(user);
        entityManager.flush();

        Optional<User>found=userRepository.findByUsername("sandu@gmail.com");
        assertThat(found.get().getUsername(),equalTo(user.getUsername()));


    }
@Test
    public void test2(){
    //to fail the test
    User user1= new User("tesfa@gmail.com");
    entityManager.persist(user1);
    entityManager.flush();

    Optional<User> existing=userRepository.findByUsername("tesfu@gmail.com");
    assertThat(existing.isPresent(),equalTo(false));
}

}
