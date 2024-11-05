package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Defis;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DefisService  extends CrudService<Defis, Long> {

    private ContexHolder contexHolder;

    public DefisService(ContexHolder contexHolder,
                        JpaRepository<Defis, Long> generalRepo) {
        super(generalRepo);
        this.contexHolder = contexHolder; // Initialisation correcte
    }

    public Defis update(Long id, Defis entity) {
        return generalRepo.findById(id)
                .map(
                    p->{
                        p.setUtilisateur(contexHolder.utilisateur());
                        p.setDescription(entity.getDescription());
                        p.setTitre(entity.getTitre());
                        p.setPiece(entity.getPiece());
                        p.setDateEnd(entity.getDateEnd());
                        p.setDateStart(entity.getDateStart());
                        return generalRepo.save(p);
                    }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
