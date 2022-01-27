package kg.inai.socfond.repos;

import kg.inai.socfond.entities.TypePensiya;
import kg.inai.socfond.entities.TypeRodstva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePensiyaRepo extends JpaRepository<TypePensiya, Long> {
}
