package kg.inai.socfond.repos;

import kg.inai.socfond.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}
