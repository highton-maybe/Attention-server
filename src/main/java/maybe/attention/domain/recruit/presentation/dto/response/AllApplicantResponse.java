package maybe.attention.domain.recruit.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AllApplicantResponse {
    private final String applicantName;
    private final String phoneNumber;
    private final String email;
}
