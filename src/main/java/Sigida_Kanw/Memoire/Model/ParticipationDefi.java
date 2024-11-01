package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ParticipationDefi {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Instant dateParticipation;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonBackReference("participationDefiUser")
    private Utilisateur utilisateur;

    @ManyToOne
    private Defis Defis;

    @ManyToOne
    private StatutParticipation StatutParticipation;
}
