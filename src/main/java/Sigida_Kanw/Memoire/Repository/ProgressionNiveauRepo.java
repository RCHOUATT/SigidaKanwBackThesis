package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ProgressionNiveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionNiveauRepo extends JpaRepository<ProgressionNiveau, Long> {
}
