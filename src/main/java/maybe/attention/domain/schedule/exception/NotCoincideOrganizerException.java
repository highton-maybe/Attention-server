package maybe.attention.domain.schedule.exception;

import lombok.Getter;
import maybe.attention.global.exception.ErrorCode;

@Getter
public class NotCoincideOrganizerException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotCoincideOrganizerException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_COINCIDE_ORGANIZER;
    }
}
