package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.StatutParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutParticipationRepo extends JpaRepository<StatutParticipation, Long> {

}
