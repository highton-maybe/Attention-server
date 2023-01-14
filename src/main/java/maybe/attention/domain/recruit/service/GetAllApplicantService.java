package maybe.attention.domain.recruit.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.AuditionMember;
import maybe.attention.domain.member.repo.AuditionMemberRepository;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.recruit.exception.NotFoundAuditionMemberException;
import maybe.attention.domain.recruit.exception.NotFoundContestRecruitException;
import maybe.attention.domain.recruit.presentation.dto.response.AllApplicantResponse;
import maybe.attention.domain.recruit.repo.ContestRecruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllApplicantService {

    private final ContestRecruitRepository contestRecruitRepository;
    private final AuditionMemberRepository auditionMemberRepository;

    public List<AllApplicantResponse> execute(Long id) {
        ContestRecruit contestRecruit = contestRecruitRepository.findById(id)
                .orElseThrow(() -> new NotFoundContestRecruitException("존재하지 않는 모집공"));
        List<AuditionMember> auditionMembers = auditionMemberRepository.findAllByContestRecruit(contestRecruit);

        if(auditionMembers.isEmpty())
            throw new NotFoundAuditionMemberException("존재하지 않는 신청자");

        List<AllApplicantResponse> responses = auditionMembers.stream()
                .map(s -> new AllApplicantResponse(s.getAuditionMember().getName(), s.getAuditionMember().getPhoneNumber(), s.getAuditionMember().getEmail()))
                .collect(Collectors.toList());

        return responses;
    }
}
