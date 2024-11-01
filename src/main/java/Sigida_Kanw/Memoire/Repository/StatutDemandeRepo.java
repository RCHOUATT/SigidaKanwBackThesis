package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.StatutDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDemandeRepo extends JpaRepository<StatutDemande, Long> {
}
