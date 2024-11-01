package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.TypeCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCoursRepo extends JpaRepository<TypeCours, Long> {
    TypeCours findByType(String type);
}
