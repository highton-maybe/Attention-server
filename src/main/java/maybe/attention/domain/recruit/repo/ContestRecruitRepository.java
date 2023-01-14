package maybe.attention.domain.recruit.repo;

import maybe.attention.domain.recruit.ContestRecruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRecruitRepository extends JpaRepository<ContestRecruit , Long> {
}
