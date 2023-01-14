package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.exception.NotFoundContestRecruitException;
import maybe.attention.domain.recruit.presentation.dto.response.LookUpContestRecruitResponse;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import maybe.attention.domain.schedule.exception.NotCoincideOrganizerException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LookUpContestRecruitService {

    private final ContestRecruitRepository contestRecruitRepository;
    private final MemberFacade memberFacade;

    public LookUpContestRecruitResponse execute(Long id) {
        ContestRecruit contestRecruit = contestRecruitRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestRecruitException("존재하지 않는 모집 공고입니다."));
        Member currentMember = memberFacade.getCurrentMember();

        if(contestRecruit.getMember() != currentMember)
            throw new NotCoincideOrganizerException("주최자와 유저와 정보가 일치하지 않습니다.");

        LookUpContestRecruitResponse response = LookUpContestRecruitResponse.builder()
                .recruitTitle(contestRecruit.getRecruitTitle())
                .recruitContent(contestRecruit.getRecruitContent())
                .recruitStartDate(contestRecruit.getRecruitStartDate())
                .recruitEndDate(contestRecruit.getRecruitEndDate())
                .organizerName(contestRecruit.getMember().getName())
                .build();

        return response;
    }
}
