package maybe.attention.domain.member.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.presentation.dto.response.GetMemberRecruitResponse;
import maybe.attention.domain.recruit.ContestRecruit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMemberRecruitService {

    private final MemberFacade memberFacade;

    public List<GetMemberRecruitResponse> execute() {
        Member currentMember = memberFacade.getCurrentMember();
        List<ContestRecruit> recruits = currentMember.getRecruits();

        List<GetMemberRecruitResponse> responses = recruits.stream()
                .map(r -> new GetMemberRecruitResponse(r.getRecruitTitle(), r.getRecruitStartDate(), r.getRecruitEndDate(), r.getMember().getName()))
                .collect(Collectors.toList());

        return responses;
    }
}
