package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.TypeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTestRepo extends JpaRepository<TypeTest, Long> {
    TypeTest findByType(String type);
}
