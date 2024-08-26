package africa.semicolon.myapp.data.repositories;

import africa.semicolon.myapp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
