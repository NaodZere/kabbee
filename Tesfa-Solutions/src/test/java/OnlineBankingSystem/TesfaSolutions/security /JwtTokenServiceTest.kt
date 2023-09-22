import OnlineBankingSystem.TesfaSolutions.model.User
import OnlineBankingSystem.TesfaSolutions.service.impl.JwtTokenService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class JwtTokenServiceTest {
    private var jwtTokenService: JwtTokenService? = null

    @Mock
    private val mockUser: User? = null
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        // Replace 'yourSecretKey' with the actual secret key value
        jwtTokenService = JwtTokenService("yourSecretKey")
    }

    @Test
    fun testTokenGenerationAndValidation() {
        // Create a mock user
        Mockito.`when`(mockUser!!.username).thenReturn("testUser")

        // Generate a token for the mock user
        val token = jwtTokenService!!.generateToken(mockUser)

        // Validate the token and get the username from it
        val username = jwtTokenService!!.validateTokenAndGetUsername(token)

        Assertions.assertEquals("testUser", username)
    }

    @Test
    fun testInvalidTokenValidation() {
        // Attempt to validate an invalid token
        val invalidToken = "invalidToken"

        // Validate the invalid token (should return null)
        val username = jwtTokenService!!.validateTokenAndGetUsername(invalidToken)

        // Assert that the username is null for an invalid token
        Assertions.assertNull(username)
    }
}
