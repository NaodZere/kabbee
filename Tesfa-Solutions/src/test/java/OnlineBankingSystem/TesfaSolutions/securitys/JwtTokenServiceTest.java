package OnlineBankingSystem.TesfaSolutions.securitys;

import OnlineBankingSystem.TesfaSolutions.model.User;
import OnlineBankingSystem.TesfaSolutions.service.impl.JwtTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class JwtTokenServiceTest {

    private JwtTokenService jwtTokenService;

    @Mock
    private User mockUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Replace 'yourSecretKey' with the actual secret key value
        jwtTokenService = new JwtTokenService("yourSecretKey");
    }

    @Test
    public void testTokenGenerationAndValidation() {
        // Create a mock user
        Mockito.when(mockUser.getUsername()).thenReturn("testUser");

        // Generate a token for the mock user
        String token = jwtTokenService.generateToken(mockUser);

        // Validate the token and get the username from it
        String username = jwtTokenService.validateTokenAndGetUsername(token);

        Assertions.assertEquals("testUser", username);
    }

    @Test
    public void testInvalidTokenValidation() {
        // Attempt to validate an invalid token
        String invalidToken = "invalidToken";

        // Validate the invalid token (should return null)
        String username = jwtTokenService.validateTokenAndGetUsername(invalidToken);

        // Assert that the username is null for an invalid token
        Assertions.assertNull(username);
    }
}
