package maybe.attention.domain.schedule.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class LookUpContestScheduleResponse {

    private final Long scheduleId;
    private final String scheduleTitle;
    private final String scheduleContent;
    private final String scheduleDate;
    private final String organizerName;
}
