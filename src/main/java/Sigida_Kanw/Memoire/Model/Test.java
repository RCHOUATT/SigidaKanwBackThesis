package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Test {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String description;
    private Integer nbrePoint;

    @ManyToOne
    @JsonBackReference("TestUser")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "chapitre_Id")
    @JsonBackReference("testPerchapitre")
    private Chapitre chapitre;

    @ManyToOne
    private TypeTest typeTest;

    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("storyquizId")
    private List<HistoriqueQuiz> historiqueQuizList;

    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("questionPerTest")
    private List<Question> questionList;
}
/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
