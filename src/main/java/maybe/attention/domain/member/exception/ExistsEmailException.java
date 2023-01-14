package maybe.attention.domain.member.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class ExistsEmailException extends RuntimeException {

    private final ErrorCode errorCode;

    public ExistsEmailException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_EMAIL;
    }

}
