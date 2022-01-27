package kg.inai.socfond.repos;

import kg.inai.socfond.entities.DocumentBrak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentBrakRepo extends JpaRepository<DocumentBrak, Long> {
}
