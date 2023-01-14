package maybe.attention.domain.recruit.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class LookUpContestRecruitResponse {
    private final Long recruitId;
    private final String recruitTitle;
    private final String recruitContent;
    private final String recruitStartDate;
    private final String recruitEndDate;
    private final String organizerName;
}
