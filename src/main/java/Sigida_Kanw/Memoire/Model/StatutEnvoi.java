package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class StatutEnvoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;
    private String statut;
   // @OneToMany(mappedBy = "status")
    //@JsonManagedReference("notifR")
   // private List<Notification> notification;

}