package kg.inai.socfond.repos;

import kg.inai.socfond.entities.Oblast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OblastRepo extends JpaRepository<Oblast, Long> {

    Oblast getByCode(String code);

    Oblast getOblastByAteCode(Integer ateCode);
}
