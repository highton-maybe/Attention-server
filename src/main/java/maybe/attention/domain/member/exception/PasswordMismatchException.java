package maybe.attention.domain.member.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class PasswordMismatchException extends RuntimeException{

    private final ErrorCode errorCode;

    public PasswordMismatchException(String message) {
        super(message);
        this.errorCode = ErrorCode.MISMATCH_MEMBER_PASSWORD;
    }
}
