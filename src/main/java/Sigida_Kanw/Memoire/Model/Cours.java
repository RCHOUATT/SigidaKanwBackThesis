package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cours {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "niveau_etudes_id")
    private NiveauEtudes niveauEtudes;

    @ManyToOne
    private TypeCours typeCours;

    @ManyToOne
    @JoinColumn(name = "langue_Id")
    private Langue langue;
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/