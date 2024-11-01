package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class HistoriqueQuiz {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Instant datePassage;
    private Integer scrore;
    private Integer piece;

    @ManyToOne
    @JoinColumn(name = "quiz_Id")
    @JsonBackReference("storyquizId")
    private Test test;



    @ManyToOne
    @JoinColumn(name = "storyQuizUser_id")
    @JsonBackReference("storyQuizUser")
    private Utilisateur utilisateur;
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
