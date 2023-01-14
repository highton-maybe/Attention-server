package maybe.attention.domain.member.repo;

import maybe.attention.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member , Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
}
