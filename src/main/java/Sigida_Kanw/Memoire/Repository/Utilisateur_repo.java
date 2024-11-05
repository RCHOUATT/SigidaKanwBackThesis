package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.RoleUser;
import Sigida_Kanw.Memoire.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Utilisateur_repo extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findByRole(RoleUser roleUser);
    List<Utilisateur> findByNom(String nom);
}
