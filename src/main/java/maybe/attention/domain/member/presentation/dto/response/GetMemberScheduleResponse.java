package maybe.attention.domain.member.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Builder
@RequiredArgsConstructor
public class GetMemberScheduleResponse {
    private final String scheduleTitle;
    private final String scheduleDate;
    private final String organizerName;
}
