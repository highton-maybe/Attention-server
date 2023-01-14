package maybe.attention.domain.recruit.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class NotFoundContestRecruitException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundContestRecruitException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_CONTEST_RECRUIT;
    }
}
