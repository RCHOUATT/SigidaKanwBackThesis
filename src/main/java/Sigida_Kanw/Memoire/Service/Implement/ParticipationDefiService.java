package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ParticipationDefi;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipationDefiService  extends CrudService<ParticipationDefi, Long> {

    public ParticipationDefiService(JpaRepository<ParticipationDefi, Long> generalRepo) {
        super(generalRepo);
    }

   public ParticipationDefi update(Long id, ParticipationDefi entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setDateParticipation(entity.getDateParticipation());
                            p.setStatutParticipation(entity.getStatutParticipation());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
