package maybe.attention.global.security.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class TokenExpirationException extends RuntimeException{
    private final ErrorCode errorCode;

    public TokenExpirationException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
