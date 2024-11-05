package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ActiviteUtilisateur;
import Sigida_Kanw.Memoire.Repository.ActiviteUtilisateurRepo;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ActiviteUtilisateurService  extends CrudService<ActiviteUtilisateur, Long> {

    private ActiviteUtilisateurRepo activiteUtilisateurRepo;
    private ContexHolder contexHolder;

    @Autowired // Annotation d'injection automatique
    public ActiviteUtilisateurService(ActiviteUtilisateurRepo activiteUtilisateurRepo,
                                      ContexHolder contexHolder,
                                      JpaRepository<ActiviteUtilisateur, Long> generalRepo) {
        super(generalRepo);
        this.activiteUtilisateurRepo = activiteUtilisateurRepo; // Initialisation correcte
        this.contexHolder = contexHolder; // Initialisation correcte
    }

//    public List<Object[]> getWeeklyUniqueUserActivityCounts() {
//        return activiteUtilisateurRepo.findUniqueUserActivityCountsByWeek();
//    }


    public ActiviteUtilisateur update(Long id, ActiviteUtilisateur entity) {
        return activiteUtilisateurRepo.findById(id)
            .map(
                p->{
                    p.setUtilisateur(contexHolder.utilisateur());
                    p.setDateUtilisation(Instant.now());
                    return activiteUtilisateurRepo.save(p);
                }
            ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
