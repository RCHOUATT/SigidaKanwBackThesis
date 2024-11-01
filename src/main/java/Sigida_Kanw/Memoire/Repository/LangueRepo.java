package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueRepo extends JpaRepository<Langue, Long> {
    Langue findByNom(String nom);
}
