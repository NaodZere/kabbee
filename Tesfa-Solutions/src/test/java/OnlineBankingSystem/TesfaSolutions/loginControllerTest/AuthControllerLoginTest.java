package OnlineBankingSystem.TesfaSolutions.loginControllerTest;

import OnlineBankingSystem.TesfaSolutions.controller.AuthController;
import OnlineBankingSystem.TesfaSolutions.dto.LoginDTO;
import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.repository.UserRepository;
import OnlineBankingSystem.TesfaSolutions.service.impl.JwtTokenService;
import OnlineBankingSystem.TesfaSolutions.dto.TokenDTO;
import OnlineBankingSystem.TesfaSolutions.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class AuthControllerLoginTest {
    @Mock
    private UserServiceImpl userService;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtTokenService jwtTokenService;
    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        // Create a mock LoginDTO object
        LoginDTO dto = new LoginDTO("username", "password");

        // Create a mock User object
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");


        when(userService.findByUserName("username")).thenReturn(Optional.of(user));

        // Mock the passwordEncoder.matches() method to return true
        when(passwordEncoder.matches("password", user.getPassword())).thenReturn(true);

        // Mock the jwtTokenService.generateToken() method to return a valid token
        String token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJra2FobWVkaUBnbWFpbC5jb20iLCJpc";
        when(jwtTokenService.generateToken(user)).thenReturn(token);

        // Assert that the returned token is the same as the mocked token
        TokenDTO tokenDTO = authController.login(dto);
        assertEquals(token,tokenDTO.accessToken());


//        assertEquals(token, tokenDTO.getToken());
        //assertNotEquals(token, tokenDTO.getToken());
    }
}
