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
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String question;
    private String reponseCorrecte;

    /*@ManyToOne
    private TypeQuestion typeQuestion;*/

    @ManyToOne
    @JoinColumn(name = "test_Id")
    private Test test;

    @ManyToMany
    @JoinTable(
            name = "Questions_files"
    )
    private List<Files> files = new ArrayList<>();
}
/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
