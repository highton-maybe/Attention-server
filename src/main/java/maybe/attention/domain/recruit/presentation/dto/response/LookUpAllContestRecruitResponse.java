package maybe.attention.domain.recruit.presentation.dto.response;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class LookUpAllContestRecruitResponse {
    private final String recruitTitle;
    private final String recruitStartDate;
    private final String recruitEndDate;
    private final String organizerName;
}
