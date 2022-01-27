package kg.inai.socfond.repos;

import kg.inai.socfond.entities.PrichinaObrasheniya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrichinaObrasheniyaRepo extends JpaRepository<PrichinaObrasheniya, Long> {
}
