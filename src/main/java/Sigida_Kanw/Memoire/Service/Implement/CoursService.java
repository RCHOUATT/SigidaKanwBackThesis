package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.Cours;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursService extends CrudService<Cours, Long> {

    public CoursService(JpaRepository<Cours, Long> generalRepo) {
        super(generalRepo);
    }

    public Cours update(Long id, Optional<Cours> entity) {
        return generalRepo.findById(id)
            .map(
                p->{
                    if (entity.get().getTitre() != null){
                        p.setTitre(entity.get().getTitre());
                    }
                    if (entity.get().getDescription() != null){
                        p.setDescription(entity.get().getDescription());
                    }
                    if (entity.get().getNiveauEtudes() != null){
                        p.setNiveauEtudes(entity.get().getNiveauEtudes());
                    }
                    if (entity.get().getTypeCours()!= null){
                        p.setTypeCours(entity.get().getTypeCours());
                    }
                    return generalRepo.save(p);
                }
            ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
