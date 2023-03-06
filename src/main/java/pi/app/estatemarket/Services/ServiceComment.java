package pi.app.estatemarket.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pi.app.estatemarket.Entities.Comment;
import pi.app.estatemarket.Entities.Publication;
import pi.app.estatemarket.Entities.User;
import pi.app.estatemarket.Repository.CommentRepository;
import pi.app.estatemarket.Repository.PublicationRepository;
import pi.app.estatemarket.Repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceComment implements IServiceComment{
    CommentRepository commentRepository;
    PublicationRepository publicationRepository;
    UserRepository userRepository;

    @Override
    public List<Comment> retrieveAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Comment comm) {
        return commentRepository.save(comm);
    }

    @Override
    public Comment addComment(Comment comm) {
        return commentRepository.save(comm);
    }

    @Override
    public Comment retrieveComment(Integer IdComment) {
        return commentRepository.findById(IdComment).get();
    }

    @Override
    public void removeComment(Integer IdComment) {
        commentRepository.deleteById(IdComment);
    }

    @Override
    public void AffectPubToComment(int IdComment, int IdPublication) {
        Comment comment = commentRepository.findById(IdComment).orElse(null);
        Publication publication = publicationRepository.findById(IdPublication).orElse(null);
        comment.setCommPub(publication);
        commentRepository.save(comment);
    }

    @Override
    public void ajouterEtAffecterCommentaireAUserEtCommentaire(Comment comment, Long userID, int IdPublication) {
        User user = userRepository.findById(userID).orElse(null);
        Publication publication = publicationRepository.findById(IdPublication).orElse(null);
        comment.setCommPub(publication);
        comment.setUserComment(user);
        commentRepository.save(comment);

    }
}
