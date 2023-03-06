package pi.app.estatemarket.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pi.app.estatemarket.Entities.Comment;
import pi.app.estatemarket.Services.IServiceComment;

import java.util.List;

@AllArgsConstructor
@RestController
public class ControllerComment {

    IServiceComment iServiceComment;
    @GetMapping("/RetrieveAllComments")
    List<Comment> retrieveAllComments(){

        return iServiceComment.retrieveAllComments();
    }

    @PutMapping("/UpdateComment")
    Comment updateComment (@RequestBody Comment comm){

        return iServiceComment.updateComment(comm);
    }

    @PostMapping("/AddComment")
    Comment addComment (@RequestBody Comment comm){

        return iServiceComment.addComment(comm);
    }

    @GetMapping("/retrieveComment/{IdComment}")
    Comment retrieveComment (Integer IdComment){

        return iServiceComment.retrieveComment(IdComment);
    }

    @DeleteMapping("/DeleteComment/{IdComment}")
    void removeComment (Integer IdComment){

        iServiceComment.removeComment(IdComment);
    }

    @PostMapping("/AffectPubToComment/{IdComment}/{IdPublication}")
    public void AffectPubToComment(@PathVariable int IdComment,@PathVariable int IdPublication){
        iServiceComment.AffectPubToComment(IdComment, IdPublication);
    }

    @PostMapping("/ajouterEtAffecterCommentaireAUserEtCommentaire/{userID}/{IdPublication}")
    public void ajouterEtAffecterCommentaireAUserEtCommentaire(@RequestBody Comment comment, @PathVariable Long userID, @PathVariable int IdPublication){
        iServiceComment.ajouterEtAffecterCommentaireAUserEtCommentaire(comment, userID, IdPublication);
    }
}
