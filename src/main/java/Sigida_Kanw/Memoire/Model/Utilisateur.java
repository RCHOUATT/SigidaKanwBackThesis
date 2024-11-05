package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(unique = true, nullable = false)
    private String email;
    private Date dateBirthday;
    private String adresse;
    @Column(unique = true)
    private String telephone;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    //@JsonManagedReference("usersRole")
    private RoleUser role;

    @ManyToOne
    @JoinColumn(name = "paysid")
    private Pays pays;


    @ManyToOne
    @JoinColumn(name = "genre_id")
    //@JsonManagedReference("usersGenre")
    private GenreUser genreUser;

    /*@ManyToOne
    @JoinColumn(name = "niveauEtude_Id")
    //@JsonBackReference("usersLevel")
    private NiveauEtudes niveauEtudes;*/

    @ManyToOne
    @JoinColumn(name = "stat")
    //@JsonManagedReference("usersRole")
    private StatsApprenant stat;

    @ManyToOne
    private Files files;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("storyQuizUser")
    private List<HistoriqueQuiz> historiqueQuizList;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("participationDefiUser")
    private List<ParticipationDefi> participationDefiList;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("defisUser")
    private List<Defis> defisList;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("ActivityUser")
    private List<ActiviteUtilisateur> activiteUtilisateurList;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("coursUser")
    private List<Cours> CoursList;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("TestUser")
    private List<Test> TestList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((new SimpleGrantedAuthority(this.getRole().getRole())));
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
