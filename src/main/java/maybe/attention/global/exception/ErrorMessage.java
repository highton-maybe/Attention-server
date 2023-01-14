package maybe.attention.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private final String message;
    private final int status;
}