package maybe.attention.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.schedule.ContestSchedule;
import maybe.attention.domain.schedule.exception.NotCoincideOrganizerException;
import maybe.attention.domain.schedule.exception.NotFoundContestScheduleException;
import maybe.attention.domain.schedule.presentation.dto.request.UpdateScheduleRequest;
import maybe.attention.domain.schedule.repo.ContestScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateContestScheduleService {

    private final ContestScheduleRepository contestScheduleRepository;
    private final MemberFacade memberFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id , UpdateScheduleRequest request) {
        Member currentMember = memberFacade.getCurrentMember();
        ContestSchedule contestSchedule = contestScheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestScheduleException("축제 일정이 존재하지 않습니다."));

        if(contestSchedule.getMember() != currentMember)
            throw new NotCoincideOrganizerException("주최자와 유저의 정보가 동일하지 않습니다.");

        contestSchedule.updateContestSchedule(request.getScheduleTitle(), request.getScheduleContent(), request.getScheduleDate());
        contestScheduleRepository.save(contestSchedule);
    }
}
