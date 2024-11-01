package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Defis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefisRepo extends JpaRepository<Defis, Long> {
}
