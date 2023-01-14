package maybe.attention.domain.member.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class MemberNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public MemberNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.MEMBER_NOT_FOUND;
    }
}
