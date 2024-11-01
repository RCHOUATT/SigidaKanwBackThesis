package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepo extends JpaRepository<Pays, Long> {
    Pays findByPays(String pays);
}
