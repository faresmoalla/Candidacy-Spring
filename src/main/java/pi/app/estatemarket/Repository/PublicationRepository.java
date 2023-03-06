package pi.app.estatemarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pi.app.estatemarket.Entities.Publication;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

    //nombre de commentaire par publication
    @Query("SELECT COUNT(c) FROM comments c WHERE c.commPub.IdPublication = :idPublication")
    Long countCommentsByPublicationId(@Param("idPublication") Integer idPublication);



    //afficher les publication avec tous les commentaires
    @Query("SELECT p FROM publication p LEFT JOIN FETCH p.commentsPub WHERE p.IdPublication = :id")
    Optional<Publication> findPublicationWithCommentsById(@Param("id") int id);

    //pub les plus commentées
    List<Publication> findAllByOrderByCommentsPubDesc();
}
