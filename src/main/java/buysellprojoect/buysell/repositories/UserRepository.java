package buysellprojoect.buysell.repositories;

import buysellprojoect.buysell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
