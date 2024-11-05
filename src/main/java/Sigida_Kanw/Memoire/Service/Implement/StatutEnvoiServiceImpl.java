package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.StatutEnvoi;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StatutEnvoiServiceImpl extends CrudService<StatutEnvoi, Long> {

    public StatutEnvoiServiceImpl(JpaRepository<StatutEnvoi, Long> generalRepo) {
        super(generalRepo);
    }

    public StatutEnvoi MAJ(Long Id, StatutEnvoi statutEnvoi) {
        return generalRepo.findById(Id)
                .map(p->{
                    p.setStatut(statutEnvoi.getStatut());
                    return generalRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour du statut d'envoi"));
    }
}
