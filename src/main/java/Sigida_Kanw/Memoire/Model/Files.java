package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Files {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String url;
    private String type;

    //@OneToMany(mappedBy = "role")
    //@JsonBackReference ("usersRole")
    //private List<Utilisateur> utilisateur;
}
