package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ProgressionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionCoursRepo extends JpaRepository<ProgressionCours, Long> {
}
