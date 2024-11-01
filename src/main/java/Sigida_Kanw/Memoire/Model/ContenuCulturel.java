/*
package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class ContenuCulturel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titre;
    private String description;

    @ManyToOne
    private Cours cours;
    @ManyToOne
    private Files files;
}
*/
