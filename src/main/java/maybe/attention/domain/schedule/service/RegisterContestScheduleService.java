package maybe.attention.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.repo.MemberRepository;
import maybe.attention.domain.schedule.ContestSchedule;
import maybe.attention.domain.schedule.presentation.dto.request.RegisterScheduleRequest;
import maybe.attention.domain.schedule.repo.ContestScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterContestScheduleService {

    private final ContestScheduleRepository contestScheduleRepository;
    private final MemberFacade memberFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(RegisterScheduleRequest request) {
        Member currentMember = memberFacade.getCurrentMember();

        ContestSchedule contestSchedule = ContestSchedule.builder()
                .scheduleTitle(request.getScheduleTitle())
                .scheduleContent(request.getScheduleContent())
                .scheduleDate(request.getScheduleDate())
                .member(currentMember)
                .build();

        currentMember.addSchedule(contestSchedule);
        contestScheduleRepository.save(contestSchedule);
    }
}
