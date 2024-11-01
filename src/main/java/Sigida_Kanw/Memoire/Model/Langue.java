package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la langue ne peut pas être vide")
    @Size(max = 3000, message = "Le nom de la langue ne peut pas dépasser 3000 caractères")
    @Column(length = 3000)
    private String nom;

    @Size(max = 3000, message = "La description ne peut pas dépasser 3000 caractères")
    @Column(length = 3000)
    private String apropos;

    @OneToMany(mappedBy = "langue", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("langueCour")
    private List<Cours> coursList;
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
