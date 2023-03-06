package pi.app.estatemarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.app.estatemarket.Entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
