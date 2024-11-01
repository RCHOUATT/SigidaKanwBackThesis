package Sigida_Kanw.Memoire.Repository;


import Sigida_Kanw.Memoire.Model.GenreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreUserRepo extends JpaRepository<GenreUser, Long> {
    GenreUser findByGenre(String genre);
}