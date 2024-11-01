package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Langue;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LangueService extends CrudService<Langue, Long> {

    private final ContexHolder contexHolder;

    public LangueService(ContexHolder contexHolder,
                         JpaRepository<Langue, Long> generalRepo) {
        super(generalRepo);
        this.contexHolder = contexHolder;
    }

    public Langue update(Long id, Langue entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setNom(entity.getNom());
                            p.setApropos(entity.getApropos());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
