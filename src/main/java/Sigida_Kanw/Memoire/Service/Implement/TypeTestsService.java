package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.TypeTest;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeTestsService extends CrudService<TypeTest, Long> {

    public TypeTestsService(JpaRepository<TypeTest, Long> generalRepo) {
        super(generalRepo);
    }

    public TypeTest update(Long id, TypeTest entity) {
        return generalRepo.findById(id)
            .map(
                p -> {
                    p.setType(entity.getType());
                    return generalRepo.save(p);
                }
            ).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}