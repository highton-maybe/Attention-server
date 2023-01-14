package maybe.attention.domain.member.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.presentation.dto.response.GetMemberScheduleResponse;
import maybe.attention.domain.schedule.ContestSchedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMemberScheduleService {

    private final MemberFacade memberFacade;

    public List<GetMemberScheduleResponse> execute() {
        Member currentMember = memberFacade.getCurrentMember();
        List<ContestSchedule> schedules = currentMember.getSchedules();
        List<GetMemberScheduleResponse> responses = schedules.stream()
                .map(s -> new GetMemberScheduleResponse(s.getScheduleTitle(), s.getScheduleDate(), s.getMember().getName()))
                .collect(Collectors.toList());
        return responses;
    }

}
