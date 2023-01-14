package maybe.attention.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.ContestSchedule;
import maybe.attention.domain.schedule.exception.NotFoundContestScheduleException;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpAllContestScheduleResponse;
import maybe.attention.domain.schedule.repo.ContestScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LookUpAllScheduleService {

    private final ContestScheduleRepository contestScheduleRepository;

    public List<LookUpAllContestScheduleResponse> execute() {
        List<ContestSchedule> contestSchedules = contestScheduleRepository.findAll();

        if(contestSchedules.isEmpty())
            throw new NotFoundContestScheduleException("축제 일정을 찾을 수 없습니다.");

        List<LookUpAllContestScheduleResponse> response = contestSchedules.stream()
                .map(c -> new LookUpAllContestScheduleResponse(c.getScheduleTitle(), c.getScheduleDate(), c.getMember().getName()))
                .collect(Collectors.toList());

        return response;
    }
}
