package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.NiveauEtudes;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class NiveauEtudesService  extends CrudService<NiveauEtudes, Long> {

    public NiveauEtudesService(ContexHolder contexHolder,
                         JpaRepository<NiveauEtudes, Long> generalRepo) {
        super(generalRepo);
    }

    public NiveauEtudes update(Long id, NiveauEtudes entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setNiveau(entity.getNiveau());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
