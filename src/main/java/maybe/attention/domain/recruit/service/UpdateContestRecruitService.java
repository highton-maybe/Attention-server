package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.exception.NotFoundContestRecruitException;
import maybe.attention.domain.recruit.presentation.dto.request.UpdateContestRecruitRequest;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import maybe.attention.domain.schedule.exception.NotCoincideOrganizerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateContestRecruitService {

    private final ContestRecruitRepository contestRecruitRepository;
    private final MemberFacade memberFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id, UpdateContestRecruitRequest request) {
        Member currentMember = memberFacade.getCurrentMember();
        ContestRecruit contestRecruit = contestRecruitRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestRecruitException("존재하지 않는 모집 공고 입니다."));

        if(!contestRecruit.getMember().equals(currentMember))
            throw new NotCoincideOrganizerException("주최자와 유저의 정보가 동일하지 않습니다.");

        contestRecruit.updateContestRecruit(request.getRecruitTitle(), request.getRecruitContent(),
                request.getRecruitStartDate(), request.getRecruitEndDate());

        contestRecruitRepository.save(contestRecruit);
    }
}
