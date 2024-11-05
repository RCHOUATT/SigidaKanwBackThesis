package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenuRepo extends JpaRepository<Contenu, Long> {
}
