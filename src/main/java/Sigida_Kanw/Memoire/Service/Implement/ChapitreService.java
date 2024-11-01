package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Chapitre;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ChapitreService extends CrudService<Chapitre, Long> {

    private ContexHolder contexHolder;

    public ChapitreService(ContexHolder contexHolder,
                           JpaRepository<Chapitre, Long> generalRepo) {
        super(generalRepo);
        this.contexHolder = contexHolder; // Initialisation correcte
    }

    public Chapitre update(Long id, Chapitre entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setTitre(entity.getTitre());
                            p.setCours(entity.getCours());
                            p.setResume(entity.getResume());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
