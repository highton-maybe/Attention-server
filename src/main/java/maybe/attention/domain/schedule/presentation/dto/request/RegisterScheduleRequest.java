package maybe.attention.domain.schedule.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterScheduleRequest {

    @NotBlank
    private String scheduleTitle;
    @NotBlank
    private String scheduleContent;
    @NotBlank
    private String scheduleDate;
}
