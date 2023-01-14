package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAllRecruitService {

    private final ContestRecruitRepository contestRecruitRepository;

    @Transactional(rollbackFor = Exception.class)
    public void execute() {
        contestRecruitRepository.deleteAll();
    }

}
