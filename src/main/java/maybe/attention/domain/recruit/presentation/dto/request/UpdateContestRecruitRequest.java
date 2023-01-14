package maybe.attention.domain.recruit.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContestRecruitRequest {
    @NotEmpty
    private String recruitTitle;
    @NotEmpty
    private String recruitContent;
    @NotEmpty
    private String recruitStartDate;
    @NotEmpty
    private String recruitEndDate;
}
