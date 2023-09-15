package OnlineBankingSystem.TesfaSolutions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid username or password")

public class LoginException extends RuntimeException{

    public LoginException() {

        super("Invalid username or password");
    }
}

