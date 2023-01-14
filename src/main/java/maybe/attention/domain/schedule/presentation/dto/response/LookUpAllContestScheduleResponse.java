package maybe.attention.domain.schedule.presentation.dto.response;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class LookUpAllContestScheduleResponse {
    private final String scheduleTitle;
    private final String scheduleDate;
    private final String organizerName;
}
