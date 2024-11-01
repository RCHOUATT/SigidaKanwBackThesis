package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.StatutDemande;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StatutDemandeService extends CrudService<StatutDemande, Long> {

    public StatutDemandeService(JpaRepository<StatutDemande, Long> generalRepo) {
        super(generalRepo);
    }

    public StatutDemande update(Long id, StatutDemande entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setStatut(entity.getStatut());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}

