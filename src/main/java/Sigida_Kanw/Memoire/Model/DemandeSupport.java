package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class DemandeSupport {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String description;

    @ManyToOne
    private Utilisateur Apprenant;

    @ManyToOne
    private StatutDemande statutDemande;


    //@OneToMany(mappedBy = "role")
    //@JsonBackReference ("usersRole")
    //private List<Utilisateur> utilisateur;
}