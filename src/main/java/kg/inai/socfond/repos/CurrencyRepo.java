package kg.inai.socfond.repos;

import kg.inai.socfond.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
}
