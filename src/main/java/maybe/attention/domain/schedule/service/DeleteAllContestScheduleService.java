package maybe.attention.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.schedule.repo.ContestScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAllContestScheduleService {

    private final ContestScheduleRepository contestScheduleRepository;

    @Transactional(rollbackFor = Exception.class)
    public void execute() {
        contestScheduleRepository.deleteAll();
    }
}
