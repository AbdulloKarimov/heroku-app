package kg.inai.socfond.repos;

import kg.inai.socfond.entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepo extends JpaRepository<Rayon, Long> {

    Rayon getByName(String name);

    Rayon getRayonByAteCode(Integer ateCode);

    @Query(value = "select * from rayon where rayon.name like CONCAT(:name,'%')" , nativeQuery = true)
    Rayon getRayByName(String name);
}
