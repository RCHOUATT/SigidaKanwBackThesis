package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ReponsePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponsePossibleRepo extends JpaRepository<ReponsePossible, Long> {
}
