package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.StatutParticipation;
import Sigida_Kanw.Memoire.Repository.StatutParticipationRepo;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class StatutParticipationService extends CrudService<StatutParticipation, Long> {

    public StatutParticipationService(StatutParticipationRepo generalRepo) {
        super(generalRepo);
    }

    public StatutParticipation update(Long id, StatutParticipation entity) {
        return generalRepo.findById(id)
        .map(
            p->{
                p.setStatut(entity.getStatut());
                return generalRepo.save(p);
            }).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour du statut d'envoi"));
    }
}
