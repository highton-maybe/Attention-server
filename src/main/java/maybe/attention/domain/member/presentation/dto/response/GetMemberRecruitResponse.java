package maybe.attention.domain.member.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetMemberRecruitResponse {
    private final String scheduleTitle;
    private final String scheduleStartDate;
    private final String scheduleEndDate;
    private final String organizerName;
}
