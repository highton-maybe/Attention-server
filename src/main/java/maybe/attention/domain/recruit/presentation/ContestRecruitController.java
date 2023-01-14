package maybe.attention.domain.recruit.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.recruit.presentation.dto.request.RegisterContestRecruitRequest;
import maybe.attention.domain.recruit.presentation.dto.response.LookUpAllContestRecruitResponse;
import maybe.attention.domain.recruit.service.LookUpAllContestRecruitService;
import maybe.attention.domain.recruit.service.RegisterContestRecruitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
public class ContestRecruitController {

    private final RegisterContestRecruitService registerContestRecruitService;
    private final LookUpAllContestRecruitService lookUpAllContestRecruitService;

    @PostMapping
    public ResponseEntity<Void> registerContestRecruit(@Valid @RequestBody RegisterContestRecruitRequest request) {
        registerContestRecruitService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<LookUpAllContestRecruitResponse>> lookUpAllRecruit() {
        List<LookUpAllContestRecruitResponse> response = lookUpAllContestRecruitService.execute();
        return ResponseEntity.ok().body(response);
    }


}
