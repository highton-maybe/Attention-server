package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.presentation.dto.request.RegisterContestRecruitRequest;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterContestRecruitService {

    private final ContestRecruitRepository contestRecruitRepository;
    private final MemberFacade memberFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(RegisterContestRecruitRequest request) {

        Member currentMember = memberFacade.getCurrentMember();

        ContestRecruit contestRecruit = ContestRecruit.builder()
                .recruitTitle(request.getRecruitTitle())
                .recruitContent(request.getRecruitContent())
                .recruitStartDate(request.getRecruitStartDate())
                .recruitEndDate(request.getRecruitEndDate())
                .member(currentMember)
                .auditionMembers(null)
                .build();

        contestRecruitRepository.save(contestRecruit);
    }
}
