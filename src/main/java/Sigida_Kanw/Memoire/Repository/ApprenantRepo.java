package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepo extends JpaRepository<Apprenant, Long> {
}
