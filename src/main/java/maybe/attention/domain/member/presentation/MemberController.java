package maybe.attention.domain.member.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.presentation.dto.request.MemberSignUpRequest;
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

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody MemberSignUpRequest request) {
        memberSignUpService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
