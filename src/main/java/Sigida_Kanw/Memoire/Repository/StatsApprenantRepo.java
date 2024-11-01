package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.StatsApprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsApprenantRepo extends JpaRepository<StatsApprenant, Long> {
}
