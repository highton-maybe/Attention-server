package maybe.attention.domain.member.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.presentation.dto.request.MemberLoginRequest;
import maybe.attention.domain.member.presentation.dto.request.MemberSignUpRequest;
import maybe.attention.domain.member.presentation.dto.response.TokenResponse;
import maybe.attention.domain.member.service.MemberLoginService;
import maybe.attention.domain.member.service.MemberSignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;

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
}
