package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepo extends JpaRepository<Cours, Long>{
}
