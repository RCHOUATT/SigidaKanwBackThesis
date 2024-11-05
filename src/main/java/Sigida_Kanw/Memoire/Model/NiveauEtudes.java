package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class NiveauEtudes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String niveau;

/*    @OneToMany(mappedBy = "niveauEtudes", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //@JsonManagedReference("usersLevel")
    private List<Utilisateur> utilisateur;*/

    /*@OneToMany(mappedBy = "niveauEtudes")
    @JsonManagedReference("usersLevel")
    private List<Utilisateur> utilisateurs;*/

}
