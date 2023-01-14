package maybe.attention.global.security.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class TokenNotValidException extends RuntimeException{
    private final ErrorCode errorCode;

    public TokenNotValidException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
