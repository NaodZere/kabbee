package OnlineBankingSystem.TesfaSolutions.repository;

import OnlineBankingSystem.TesfaSolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
