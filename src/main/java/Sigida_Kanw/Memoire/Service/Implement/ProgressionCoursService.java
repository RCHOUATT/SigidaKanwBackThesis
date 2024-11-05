package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ProgressionCours;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressionCoursService extends CrudService<ProgressionCours, Long> {

    public ProgressionCoursService(JpaRepository<ProgressionCours, Long> generalRepo) {
        super(generalRepo);
    }

    public ProgressionCours update(Long id, ProgressionCours entity) {
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