package maybe.attention.domain.recruit.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.recruit.presentation.dto.request.RegisterContestRecruitRequest;
import maybe.attention.domain.recruit.presentation.dto.request.UpdateContestRecruitRequest;
import maybe.attention.domain.recruit.presentation.dto.response.LookUpAllContestRecruitResponse;
import maybe.attention.domain.recruit.presentation.dto.response.LookUpContestRecruitResponse;
import maybe.attention.domain.recruit.service.LookUpAllContestRecruitService;
import maybe.attention.domain.recruit.service.LookUpContestRecruitService;
import maybe.attention.domain.recruit.service.RegisterContestRecruitService;
import maybe.attention.domain.recruit.service.UpdateContestRecruitService;
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
    private final LookUpContestRecruitService lookUpContestRecruitService;
    private final UpdateContestRecruitService updateContestRecruitService;

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

    @GetMapping("/{id}")
    public ResponseEntity<LookUpContestRecruitResponse> lookUpRecruitById(@PathVariable Long id) {
        LookUpContestRecruitResponse response = lookUpContestRecruitService.execute(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateRecruit(@PathVariable Long id, @Valid @RequestBody UpdateContestRecruitRequest request) {
        updateContestRecruitService.execute(id, request);
        return ResponseEntity.ok().build();
    }

}
