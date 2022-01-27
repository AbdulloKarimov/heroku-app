package kg.inai.socfond.repos;

import kg.inai.socfond.entities.BankingRekvisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRekvisitsRepo extends JpaRepository<BankingRekvisits, Long> {
}
