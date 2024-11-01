package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.StatsApprenant;
import Sigida_Kanw.Memoire.Repository.StatsApprenantRepo;
import Sigida_Kanw.Memoire.Service.StatsApprenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatsApprenantServiceImpl implements StatsApprenantService {

    private StatsApprenantRepo statsApprenantrepo;

    @Override
    public List<StatsApprenant> Affiche() {
        return statsApprenantrepo.findAll();
    }

    @Override
    public StatsApprenant MAJ(Long Id, StatsApprenant statsApprenant) {
        return statsApprenantrepo.findById(Id)
            .map(p->{
                p.setPoint(statsApprenant.getPoint());
                p.setNiveau(statsApprenant.getNiveau());
                return statsApprenantrepo.save(p);
            }).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour des statuts de l'apprenant"));
    }

    @Override
    public String Supp(Long Id) {
        statsApprenantrepo.deleteById(Id);
        return "Statut d'envoi supprimer";
    }
}