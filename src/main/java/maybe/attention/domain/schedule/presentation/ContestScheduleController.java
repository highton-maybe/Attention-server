package maybe.attention.domain.schedule.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.presentation.dto.request.RegisterScheduleRequest;
import maybe.attention.domain.schedule.service.RegisterContestScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ContestScheduleController {

    private final RegisterContestScheduleService registerContestScheduleService;

    @PostMapping
    public ResponseEntity<Void> registerContestSchedule(RegisterScheduleRequest request) {
        registerContestScheduleService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
