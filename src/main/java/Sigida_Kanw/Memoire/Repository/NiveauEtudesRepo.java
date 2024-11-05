package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.NiveauEtudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauEtudesRepo extends JpaRepository<NiveauEtudes, Long> {
    NiveauEtudes findByNiveau(String niveau);
}
