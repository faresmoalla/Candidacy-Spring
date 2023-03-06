package pi.app.estatemarket.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "publication")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPublication;
    private String TitrePub;
    @Temporal(TemporalType.DATE)
    private Date DatePublication;
    private String DescriptionPublication;

@JsonIgnore
    @ManyToOne
    private User userPub;

//@JsonIgnore //au cas où lezemesh les commentaires yokhrjou maa les listes de pubs
    @OneToMany(mappedBy = "commPub")
    private Set<Comment>commentsPub;

}
