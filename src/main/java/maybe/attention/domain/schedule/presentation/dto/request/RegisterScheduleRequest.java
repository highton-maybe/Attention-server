package maybe.attention.domain.schedule.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterScheduleRequest {

    @NotEmpty
    private String scheduleTitle;
    @NotEmpty
    private String scheduleContent;
    @NotEmpty
    private String scheduleDate;
}
