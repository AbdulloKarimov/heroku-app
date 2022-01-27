package kg.inai.socfond.repos;

import kg.inai.socfond.entities.CompetentOrganPoluchatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetentOrganPoluchatelRepo extends JpaRepository<CompetentOrganPoluchatel, Long> {
}
