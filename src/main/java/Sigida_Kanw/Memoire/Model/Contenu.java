package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
public class Contenu {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String description;

    @ManyToOne
    @JoinColumn(name = "chapitre_Id")
    @JsonBackReference("contenuList")
    private Chapitre chapitre;

    // Ajout de la table de jointure pour la relation ManyToMany
    @ManyToMany
    @JoinTable(
            name = "contenu_files"
    )
    private List<Files> files = new ArrayList<>();
}
