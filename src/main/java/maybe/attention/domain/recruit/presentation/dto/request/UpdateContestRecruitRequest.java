package maybe.attention.domain.recruit.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContestRecruitRequest {
    @NotBlank
    private String recruitTitle;
    @NotBlank
    private String recruitContent;
    @NotBlank
    private String recruitStartDate;
    @NotBlank
    private String recruitEndDate;
}
