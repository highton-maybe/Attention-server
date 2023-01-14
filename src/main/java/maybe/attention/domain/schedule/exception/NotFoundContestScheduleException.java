package maybe.attention.domain.schedule.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class NotFoundContestScheduleException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundContestScheduleException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_CONTEST_SCHEDULE;
    }
}
