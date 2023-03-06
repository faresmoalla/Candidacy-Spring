package pi.app.estatemarket.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "appointment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdAppointment;
    @Temporal(TemporalType.DATE)
    private Date AppointmentDate;
    private boolean AppointmentStatus;

    @ManyToOne
    private Announcement announcementApp;

    @ManyToMany(mappedBy = "appointments")
    private Set<User> users;

}
