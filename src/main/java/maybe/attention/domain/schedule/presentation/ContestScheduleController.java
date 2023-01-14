package maybe.attention.domain.schedule.presentation;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.presentation.dto.request.RegisterScheduleRequest;
import maybe.attention.domain.schedule.presentation.dto.request.UpdateScheduleRequest;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpAllContestScheduleResponse;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpContestScheduleResponse;
import maybe.attention.domain.schedule.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ContestScheduleController {

    private final RegisterContestScheduleService registerContestScheduleService;
    private final LookUpContestScheduleService lookUpContestScheduleService;
    private final LookUpAllScheduleService lookUpAllScheduleService;
    private final UpdateContestScheduleService updateContestScheduleService;
    private final DeleteContestScheduleService deleteContestScheduleService;
    private final DeleteAllContestScheduleService deleteAllContestScheduleService;

    @PostMapping
    public ResponseEntity<Void> registerContestSchedule(@Valid @RequestBody RegisterScheduleRequest request) {
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

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateContestScheduleById(@PathVariable Long id , @Valid @RequestBody UpdateScheduleRequest request) {
        updateContestScheduleService.execute(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContestScheduleById(@PathVariable Long id) {
        deleteContestScheduleService.execute(id);
        return ResponseEntity.ok().build();
    }

    // 테스트용 데이터 싹 날리기
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        deleteAllContestScheduleService.execute();
        return ResponseEntity.ok().build();
    }

}
