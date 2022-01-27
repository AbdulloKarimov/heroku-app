package kg.inai.socfond.repos;

import kg.inai.socfond.entities.PersonalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDocumentRepo extends JpaRepository<PersonalDocument, Long> {
}
