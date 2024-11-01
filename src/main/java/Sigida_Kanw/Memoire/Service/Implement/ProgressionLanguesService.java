package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ProgressionLangues;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressionLanguesService extends CrudService<ProgressionLangues, Long> {

    public ProgressionLanguesService(JpaRepository<ProgressionLangues, Long> generalRepo) {
        super(generalRepo);
    }

    public ProgressionLangues update(Long id, ProgressionLangues entity) {
        return generalRepo.findById(id)
            .map(
                p->{
                    p.setAvancement(entity.getAvancement());
                    p.setDateDernActivite(entity.getDateDernActivite());
                    return generalRepo.save(p);
                }
            ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}