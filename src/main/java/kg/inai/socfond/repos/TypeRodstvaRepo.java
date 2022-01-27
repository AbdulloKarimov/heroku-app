package kg.inai.socfond.repos;

import kg.inai.socfond.entities.TypeRodstva;
import kg.inai.socfond.entities.TypeUchastnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRodstvaRepo extends JpaRepository<TypeRodstva, Long> {
}
