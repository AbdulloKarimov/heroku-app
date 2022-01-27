package kg.inai.socfond.repos;

import kg.inai.socfond.entities.PlaceName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceNameRepo extends JpaRepository<PlaceName, Long> {
}
