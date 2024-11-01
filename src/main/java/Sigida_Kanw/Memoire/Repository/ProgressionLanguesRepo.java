
package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ProgressionLangues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionLanguesRepo extends JpaRepository<ProgressionLangues, Long> {
}
