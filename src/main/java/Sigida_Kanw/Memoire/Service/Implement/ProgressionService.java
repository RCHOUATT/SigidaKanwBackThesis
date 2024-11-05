package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Progression;
import Sigida_Kanw.Memoire.Model.ProgressionCours;
import Sigida_Kanw.Memoire.Model.ProgressionNiveau;
import Sigida_Kanw.Memoire.Repository.ProgressionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressionService {

    private ProgressionRepo progressionRepo;

    public ProgressionCours AjouterProgressionCours(ProgressionCours entity) throws Exception {
        return progressionRepo.save(entity);
    }
    public ProgressionNiveau AjouterProgressionNiveau(ProgressionNiveau entity) throws Exception {
        return progressionRepo.save(entity);
    }

    public List<Progression> displayAll() {
        return progressionRepo.findAll();
    }

    public Progression display(Long id) {
        return progressionRepo.findById(id).get();
    }

    public Progression update(Long id, Progression entity) {
        return progressionRepo.findById(id)
                .map(p->{
                    p.setAvancement(entity.getAvancement());
                    p.setDateDernActivite(entity.getDateDernActivite());
                    return progressionRepo.save(p);
                }).orElseThrow(()-> new RuntimeException("Erreur lors de la mise à jour"));
    }

    public String delete(Long id) {
        progressionRepo.deleteById(id);
        return "Progression éffacé avec succès";
    }

    public String deleteAll(){
        progressionRepo.deleteAll();
        return "Suppression reussite avec succès";
    };

    public String deleteMore(List<Long> id){
        id.forEach(e->{
            progressionRepo.deleteById(e);
        });
        return "Suppression reussite avec succès";
    };

}