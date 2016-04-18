package deltaanalytics.ftirweb.repository;

import deltaanalytics.ftirweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAccountAndPassword(String account, String password);
}
