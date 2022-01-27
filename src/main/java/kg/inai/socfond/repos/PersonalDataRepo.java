package kg.inai.socfond.repos;

import kg.inai.socfond.entities.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepo extends JpaRepository<PersonalData, Long> {
}
