package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ProgressionNiveau;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressionNiveauService extends CrudService<ProgressionNiveau, Long> {

    public ProgressionNiveauService(JpaRepository<ProgressionNiveau, Long> generalRepo) {
        super(generalRepo);
    }

    public ProgressionNiveau update(Long id, ProgressionNiveau entity) {
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
