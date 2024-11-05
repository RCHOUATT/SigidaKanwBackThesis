package Sigida_Kanw.Memoire.Service.Implement;/*package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.TypeNotification;
import Sigida_Kanw.Memoire.Model.TypeQuestion;
import Sigida_Kanw.Memoire.Service.CrudService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeQuestionsService extends CrudService<TypeQuestion, Long> {

    public TypeQuestionsService(JpaRepository<TypeQuestion, Long> generalRepo) {
        super(generalRepo);
    }

    public TypeQuestion update(Long id, TypeQuestion entity) {
        return generalRepo.findById(id)
            .map(
                p -> {
                    p.setType(entity.getType());
                    return generalRepo.save(p);
                }
            ).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}*/