package maybe.attention.domain.member.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.presentation.dto.request.MemberLoginRequest;
import maybe.attention.domain.member.presentation.dto.request.MemberSignUpRequest;
import maybe.attention.domain.member.presentation.dto.response.GetMemberRecruitResponse;
import maybe.attention.domain.member.presentation.dto.response.GetMemberScheduleResponse;
import maybe.attention.domain.member.presentation.dto.response.TokenResponse;
import maybe.attention.domain.member.service.GetMemberRecruitService;
import maybe.attention.domain.member.service.GetMemberScheduleService;
import maybe.attention.domain.member.service.MemberLoginService;
import maybe.attention.domain.member.service.MemberSignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;
    private final GetMemberScheduleService getMemberScheduleService;
    private final GetMemberRecruitService getMemberRecruitService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody MemberSignUpRequest request) {
        memberSignUpService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody MemberLoginRequest request) {
        TokenResponse response = memberLoginService.execute(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/schedule")
    public ResponseEntity<List<GetMemberScheduleResponse>> getMemberSchedules() {
        List<GetMemberScheduleResponse> responses = getMemberScheduleService.execute();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/recruit")
    public ResponseEntity<List<GetMemberRecruitResponse>> getMemberRecruits() {
        List<GetMemberRecruitResponse> responses = getMemberRecruitService.execute();
        return ResponseEntity.ok(responses);
    }
}
