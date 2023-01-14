package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.AuditionMember;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.repo.AuditionMemberRepository;
import maybe.attention.domain.member.repo.MemberRepository;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.exception.NotFoundContestRecruitException;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignForAuditionService {

    private final MemberFacade memberFacade;
    private final AuditionMemberRepository auditionMemberRepository;
    private final ContestRecruitRepository contestRecruitRepository;
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id) {
        Member currentMember = memberFacade.getCurrentMember();
        ContestRecruit contestRecruit = contestRecruitRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestRecruitException("존재하지 않는 모집 공고"));

        AuditionMember auditionMember = AuditionMember.builder()
                .auditionMember(currentMember)
                .contestRecruit(contestRecruit)
                .build();

        contestRecruit.addAuditionMember(auditionMember);
        auditionMemberRepository.save(auditionMember);
        memberRepository.save(currentMember);
    }

}
