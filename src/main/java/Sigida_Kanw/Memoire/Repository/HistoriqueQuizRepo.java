package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.HistoriqueQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueQuizRepo extends JpaRepository<HistoriqueQuiz, Long> {
}
