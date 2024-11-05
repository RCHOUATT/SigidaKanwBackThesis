package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class ActiviteUtilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Instant dateUtilisation;

    @ManyToOne
    //@JsonBackReference("ActivityUser")
    private Utilisateur utilisateur;
}
