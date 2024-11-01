package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Defis {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String description;
    private Integer piece;
    private Instant dateStart;
    private Instant dateEnd;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @JsonBackReference("defisUser")
    private Utilisateur utilisateur;
}
