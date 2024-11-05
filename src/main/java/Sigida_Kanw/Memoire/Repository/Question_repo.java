package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Question_repo extends JpaRepository<Question, Integer> {
}
