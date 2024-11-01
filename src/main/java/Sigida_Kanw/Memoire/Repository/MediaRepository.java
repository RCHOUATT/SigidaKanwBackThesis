package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Files, Long>{
    Optional<Files> findByUrl(String url);
}
