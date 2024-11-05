package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.NiveauEtudes;
import Sigida_Kanw.Memoire.Model.StatsApprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatsApprenantRepo extends JpaRepository<StatsApprenant, Long> {

    //Optional<StatsApprenant> findByApprenant_Id(Long id);
}
