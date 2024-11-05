package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
