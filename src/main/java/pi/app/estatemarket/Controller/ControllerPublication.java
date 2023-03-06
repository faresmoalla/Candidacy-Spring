package pi.app.estatemarket.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pi.app.estatemarket.Entities.Publication;
import pi.app.estatemarket.Services.IServicePublication;

import java.util.List;

@AllArgsConstructor
@RestController
public class ControllerPublication {
    IServicePublication iServicePublication;

    @GetMapping("/RetrieveAllPublications")
    List<Publication> retrieveAllPublications(){

        return iServicePublication.retrieveAllPublications();
    }
    @PutMapping("/UpdatePublication")
    Publication updatePublication (@RequestBody Publication pb){

        return iServicePublication.updatePublication(pb);
    }

    @PostMapping("/AddPublication")
    Publication  addPublication (@RequestBody  Publication pb){

        return iServicePublication.addPublication(pb);
    }
    @GetMapping("/RetrievePublication/{IdPublication}")
    Publication retrievePublication (@PathVariable Integer IdPublication){
        return iServicePublication.retrievePublication(IdPublication);
    }
@DeleteMapping("/DeletePublication/{IdPublication}")
    void removePublication (@PathVariable Integer IdPublication){
        iServicePublication.removePublication(IdPublication);


}
@PostMapping("/AffectUserToPub/{userID}/{IdPublication}")
    public void AffectUserToPub ( @PathVariable Long userID, @PathVariable int IdPublication){
        iServicePublication.AffectUserToPub(userID, IdPublication);
    }

    @PostMapping("/ajouterEtAffecterPublicationAuser/{userID}")
    public void ajouterEtAffecterPublicationAuser(@RequestBody Publication publication, @PathVariable Long userID){
        iServicePublication.ajouterEtAffecterPublicationAuser(publication, userID);
    }

    @GetMapping("/{idPublication}/comments/count")
    public Long countCommentsByPublicationId(@PathVariable Integer idPublication) {
        return iServicePublication.countCommentsByPublicationId(idPublication);
    }

    @GetMapping("/{id}")
    public Publication getPublicationWithComments(@PathVariable int id) {
        return iServicePublication.getPublicationWithComments(id);
    }

    @GetMapping("/mostCommented")
    public List<Publication> getMostCommentedPublications() {
        return iServicePublication.getMostCommentedPublications();
    }
}
