package maybe.attention.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.ContestSchedule;
import maybe.attention.domain.schedule.exception.NotFoundContestScheduleException;
import maybe.attention.domain.schedule.presentation.dto.response.LookUpContestScheduleResponse;
import maybe.attention.domain.schedule.repo.ContestScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LookUpContestScheduleService {

    private final ContestScheduleRepository contestScheduleRepository;

    @Transactional(rollbackFor = Exception.class)
    public LookUpContestScheduleResponse execute(Long id) {
        ContestSchedule contestSchedule = contestScheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestScheduleException("일정을 찾을 수 없음"));

        LookUpContestScheduleResponse response = LookUpContestScheduleResponse.builder()
                .scheduleTitle(contestSchedule.getScheduleTitle())
                .scheduleContent(contestSchedule.getScheduleContent())
                .scheduleDate(contestSchedule.getScheduleDate())
                .organizerName(contestSchedule.getMember().getName())
                .build();

        return response;
    }
}
