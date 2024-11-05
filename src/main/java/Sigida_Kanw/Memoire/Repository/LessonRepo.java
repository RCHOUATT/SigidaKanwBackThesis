package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<Chapitre, Long> {
}
