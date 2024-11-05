package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "niveauEtude_Id")
    //@JsonBackReference("usersLevel")
    private NiveauEtudes niveauEtudes;

//    @ManyToOne
//    @JoinColumn(name = "stat")
//    //@JsonManagedReference("usersRole")
//    private StatsApprenant stat;

    @ManyToOne
    private Files files;

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
