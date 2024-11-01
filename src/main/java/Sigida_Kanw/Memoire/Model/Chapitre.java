package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Chapitre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String resume;

    @ManyToOne
    @JoinColumn(name = "cour_Id")
    @JsonBackReference("chapterPerCour")
    private Cours cours;

    @OneToMany(mappedBy = "chapitre", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("contenuList")
    private List<Contenu> contenuList;

    @OneToMany(mappedBy = "chapitre", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("testPerchapitre")
    private List<Test> testList;
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
