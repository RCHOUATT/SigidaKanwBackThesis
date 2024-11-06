package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(length = 3000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "chapitre_Id")
    private Chapitre chapitre;

    // Ajout de la table de jointure pour la relation ManyToMany
    @ManyToMany
    @JoinTable(
            name = "contenu_files"
    )
    private List<Files> files = new ArrayList<>();
}
