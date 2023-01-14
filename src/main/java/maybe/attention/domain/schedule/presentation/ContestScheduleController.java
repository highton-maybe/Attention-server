package maybe.attention.domain.schedule.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.presentation.dto.request.RegisterScheduleRequest;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpAllContestScheduleResponse;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpContestScheduleResponse;
import maybe.attention.domain.schedule.service.LookUpAllScheduleService;
import maybe.attention.domain.schedule.service.LookUpContestScheduleService;
import maybe.attention.domain.schedule.service.RegisterContestScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ContestScheduleController {

    private final RegisterContestScheduleService registerContestScheduleService;
    private final LookUpContestScheduleService lookUpContestScheduleService;
    private final LookUpAllScheduleService lookUpAllScheduleService;

    @PostMapping
    public ResponseEntity<Void> registerContestSchedule(RegisterScheduleRequest request) {
        registerContestScheduleService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LookUpContestScheduleResponse> lookUpContestScheduleById(@PathVariable  Long id) {
        LookUpContestScheduleResponse response = lookUpContestScheduleService.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LookUpAllContestScheduleResponse>> lookUpAllContestSchedule() {
        List<LookUpAllContestScheduleResponse> response = lookUpAllScheduleService.execute();
        return ResponseEntity.ok(response);
    }
}
