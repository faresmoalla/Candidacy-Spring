package pi.app.estatemarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import pi.app.estatemarket.Entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
