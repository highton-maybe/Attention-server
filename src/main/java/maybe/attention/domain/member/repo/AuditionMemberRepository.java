package maybe.attention.domain.member.repo;

import maybe.attention.domain.member.AuditionMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditionMemberRepository extends JpaRepository<AuditionMember , Long> {
}
