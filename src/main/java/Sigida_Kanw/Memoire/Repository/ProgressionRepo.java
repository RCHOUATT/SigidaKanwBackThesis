package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Progression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionRepo extends JpaRepository<Progression, Long> {
}
