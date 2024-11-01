package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
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
    @JsonBackReference("coursUser")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "niveau_etudes_id")
    @JsonBackReference("niveauCour")
    private NiveauEtudes niveauEtudes;

    @ManyToOne
    private TypeCours typeCours;

    @ManyToOne
    @JoinColumn(name = "langue_Id")
    @JsonBackReference("langueCour")
    private Langue langue;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("chapterPerCour")
    private List<Chapitre> chapitreList;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("progressionCours")
    private List<ProgressionCours> progressionCoursList;
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/