package maybe.attention.domain.recruit.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.recruit.presentation.dto.request.RegisterContestRecruitRequest;
import maybe.attention.domain.recruit.service.RegisterContestRecruitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
public class ContestRecruitController {

    private final RegisterContestRecruitService registerContestRecruitService;

    @PostMapping
    public ResponseEntity<Void> registerContestRecruit(@Valid @RequestBody RegisterContestRecruitRequest request) {
        registerContestRecruitService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
