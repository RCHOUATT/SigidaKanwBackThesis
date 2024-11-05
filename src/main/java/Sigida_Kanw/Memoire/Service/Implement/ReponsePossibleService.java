package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ReponsePossible;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReponsePossibleService extends CrudService<ReponsePossible, Long> {

    public ReponsePossibleService(JpaRepository<ReponsePossible, Long> generalRepo) {
        super(generalRepo);
    }

    public ReponsePossible update(Long id, ReponsePossible entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setReponsePossible(entity.getReponsePossible());
                            p.setQuestion(entity.getQuestion());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}

