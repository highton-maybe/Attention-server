package maybe.attention.domain.schedule.repo;

import maybe.attention.domain.schedule.ContestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestScheduleRepository extends JpaRepository<ContestSchedule , Long> {
}
