package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ParticipationDefi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationDefisRepo extends JpaRepository<ParticipationDefi, Long> {
}
