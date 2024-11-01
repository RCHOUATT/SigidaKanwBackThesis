package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.DemandeSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeSupportRepo extends JpaRepository<DemandeSupport, Long> {
}
