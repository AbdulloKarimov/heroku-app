package kg.inai.socfond.repos;

import kg.inai.socfond.entities.ZnachimoeObstoyatelstvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZnachimoeObstoyatelstvoRepo extends JpaRepository<ZnachimoeObstoyatelstvo, Long> {
}
