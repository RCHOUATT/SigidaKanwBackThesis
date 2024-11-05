package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.api.services.drive.model.App;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatsApprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;

    private Integer point;
    private Integer piece;

    @ManyToOne
    private NiveauEtudes niveau;

    /*@OneToOne
    @JoinColumn(name = "apprenant_Id")
    @JsonBackReference("statApprenant")
    private Apprenant apprenant;*/

    //@OneToMany(mappedBy = "status")
    // @JsonManagedReference("notifR")
    // private List<Notification> notification;
}