package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.DemandeSupport;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandeSupportService  extends CrudService<DemandeSupport, Long> {

    private ContexHolder contexHolder;

    public DemandeSupportService(ContexHolder contexHolder,
                        JpaRepository<DemandeSupport, Long> generalRepo) {
        super(generalRepo);
        this.contexHolder = contexHolder; // Initialisation correcte
    }

    public DemandeSupport update(Long id, DemandeSupport entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setApprenant(entity.getApprenant());
                            p.setDescription(entity.getDescription());
                            p.setStatutDemande(entity.getStatutDemande());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
