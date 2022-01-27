package kg.inai.socfond.repos;

import kg.inai.socfond.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User getUserByUsername(String username);
}
