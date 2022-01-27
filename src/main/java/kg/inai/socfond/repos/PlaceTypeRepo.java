package kg.inai.socfond.repos;

import kg.inai.socfond.entities.PlaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTypeRepo extends JpaRepository<PlaceType, Long> {
}
