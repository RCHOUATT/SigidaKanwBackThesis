package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.TypeNotification;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeNotificationService extends CrudService<TypeNotification, Long> {

    public TypeNotificationService(JpaRepository<TypeNotification, Long> generalRepo) {
        super(generalRepo);
    }

    public TypeNotification update(Long id, TypeNotification entity) {
        return generalRepo.findById(id)
            .map(
                p -> {
                    p.setType(entity.getType());
                    return generalRepo.save(p);
                }
            ).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}