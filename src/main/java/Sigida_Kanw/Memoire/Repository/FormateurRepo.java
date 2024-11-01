package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepo extends JpaRepository<Formateur, Integer> {
}
