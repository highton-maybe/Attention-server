package maybe.attention.domain.member.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.presentation.dto.response.GetMemberScheduleResponse;
import maybe.attention.domain.member.repo.MemberRepository;
import maybe.attention.domain.schedule.ContestSchedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMemberScheduleService {

    private final MemberFacade memberFacade;

    public List<GetMemberScheduleResponse> execute() {
        Member currentMember = memberFacade.getCurrentMember();
        List<ContestSchedule> schedules = currentMember.getSchedules();
        List<GetMemberScheduleResponse> responses = new ArrayList<>();

        for (ContestSchedule schedule : schedules) {
            responses.add(GetMemberScheduleResponse.builder()
                    .scheduleTitle(schedule.getScheduleTitle())
                    .scheduleDate(schedule.getScheduleDate())
                    .organizerName(schedule.getMember().getName()).build());
        }
        return responses;
    }

}
