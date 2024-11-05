package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.StatutEnvoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutEnvoiRepo extends JpaRepository<StatutEnvoi, Long> {
    StatutEnvoi findByStatut(String statut);
}
