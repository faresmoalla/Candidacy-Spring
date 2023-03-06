package pi.app.estatemarket.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pi.app.estatemarket.Entities.Publication;
import pi.app.estatemarket.Entities.User;
import pi.app.estatemarket.Repository.PublicationRepository;
import pi.app.estatemarket.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ServicePublication implements IServicePublication {
    PublicationRepository publicationRepository;
    UserRepository userRepository;

    @Override
    public List<Publication> retrieveAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication updatePublication(Publication pb) {
        return publicationRepository.save(pb);
    }

    @Override
    public Publication addPublication(Publication pb) {

        return publicationRepository.save(pb);
    }

    @Override
    public Publication retrievePublication(Integer IdPublication) {
        return publicationRepository.findById(IdPublication).get();
    }

    @Override
    public void removePublication(Integer IdPublication) {
        publicationRepository.deleteById(IdPublication);
    }

    @Override
    public void AffectUserToPub(Long userID, int IdPublication) {
        Publication publication = publicationRepository.findById(IdPublication).orElse(null);
        User user = userRepository.findById(userID).orElse(null);
        publication.setUserPub(user);
        publicationRepository.save(publication);
    }

    @Override
    public void ajouterEtAffecterPublicationAuser(Publication publication, Long userID) {

        User user = userRepository.findById(userID).orElse(null);
        publication.setUserPub(user);
        publicationRepository.save(publication);
    }

    @Override
    public Long countCommentsByPublicationId(Integer idPublication) {
        return publicationRepository.countCommentsByPublicationId(idPublication);
    }

    @Override
    public Publication getPublicationWithComments(int id) {
        Optional<Publication> optionalPublication = publicationRepository.findPublicationWithCommentsById(id);
        return optionalPublication.orElseThrow(() -> new RuntimeException("Publication not found"));
    }


    @Override
    public List<Publication> getMostCommentedPublications() {
        return publicationRepository.findAllByOrderByCommentsPubDesc();
    }
}
