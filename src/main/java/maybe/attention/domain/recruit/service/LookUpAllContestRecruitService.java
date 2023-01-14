package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.exception.NotFoundContestRecruitException;
import maybe.attention.domain.recruit.presentation.dto.response.LookUpAllContestRecruitResponse;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LookUpAllContestRecruitService {

    private final ContestRecruitRepository contestRecruitRepository;

    public List<LookUpAllContestRecruitResponse> execute() {
        List<ContestRecruit> contestRecruits = contestRecruitRepository.findAll();

        if(contestRecruits.isEmpty())
            throw new NotFoundContestRecruitException("오디션 모집공고가 존재하지 않습니다.");

        List<LookUpAllContestRecruitResponse> response = contestRecruits.stream()
                .map(c -> new LookUpAllContestRecruitResponse(c.getRecruitTitle(), c.getRecruitStartDate(), c.getRecruitEndDate(), c.getMember().getName()))
                .collect(Collectors.toList());

        return response;
    }
}
