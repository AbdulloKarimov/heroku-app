package kg.inai.socfond.repos;

import kg.inai.socfond.entities.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDocumentRepo extends JpaRepository<TypeDocument, Long> {
}
