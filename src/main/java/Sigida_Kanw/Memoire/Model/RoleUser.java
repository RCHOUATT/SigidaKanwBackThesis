package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class RoleUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonBackReference("usersRole")
    private List<Utilisateur> utilisateur;
}
