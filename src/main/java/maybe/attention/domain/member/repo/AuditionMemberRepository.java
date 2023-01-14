package maybe.attention.domain.member.repo;

import maybe.attention.domain.member.AuditionMember;
import maybe.attention.domain.recruit.ContestRecruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AuditionMemberRepository extends JpaRepository<AuditionMember , Long> {
    List<AuditionMember> findAllByContestRecruit(ContestRecruit contestRecruit);

}
