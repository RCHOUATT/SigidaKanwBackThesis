package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Pays;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaysService extends CrudService<Pays, Long> {

    public PaysService(JpaRepository<Pays, Long> generalRepo) {
        super(generalRepo);
    }

    public Pays update(Long id, Pays entity) {
        return generalRepo.findById(id)
            .map(
                p -> {
                    p.setPays(entity.getPays());
                    return generalRepo.save(p);
                }
            ).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}