package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.ActiviteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteUtilisateurRepo extends JpaRepository<ActiviteUtilisateur, Long> {

//    @Query("SELECT DATE(a.dateUtilisation), COUNT(DISTINCT a.utilisateur.id) " +
//            "FROM ActiviteUtilisateur a " +
//            "WHERE a.dateUtilisation >= CURRENT_DATE - 6 " +
//            "GROUP BY DATE(a.dateUtilisation) " +
//            "ORDER BY DATE(a.dateUtilisation)")
//    List<Object[]> findUniqueUserActivityCountsByWeek();
}
