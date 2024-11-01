package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.TypeCours;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeCoursService extends CrudService<TypeCours, Long> {

    public TypeCoursService(JpaRepository<TypeCours, Long> generalRepo) {
        super(generalRepo);
    }

    public TypeCours update(Long id, TypeCours entity) {
        return generalRepo.findById(id)
            .map(
                p -> {
                    p.setType(entity.getType());
                    return generalRepo.save(p);
                }
            ).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}