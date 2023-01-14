package maybe.attention.domain.recruit.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class NotFoundAuditionMemberException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundAuditionMemberException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_AUDITION_MEMBER;
    }
}
