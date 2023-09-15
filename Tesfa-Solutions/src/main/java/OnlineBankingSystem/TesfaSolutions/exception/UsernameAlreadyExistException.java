package OnlineBankingSystem.TesfaSolutions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="UsernameAlreadyExistException")
public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException() {

        super("UsernameAlreadyExistException");
    }
}
