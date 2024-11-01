package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "niveauEtudes", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("niveauCour")
    private List<Cours> CoursList;

/*    @OneToMany(mappedBy = "niveauEtudes", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //@JsonManagedReference("usersLevel")
    private List<Utilisateur> utilisateur;*/

    /*@OneToMany(mappedBy = "niveauEtudes")
    @JsonManagedReference("usersLevel")
    private List<Utilisateur> utilisateurs;*/

}
