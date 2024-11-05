package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.StatutEnvoi;
import Sigida_Kanw.Memoire.Model.StatutParticipation;
import Sigida_Kanw.Memoire.Service.Implement.StatutEnvoiServiceImpl;
import Sigida_Kanw.Memoire.Service.Implement.StatutParticipationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/stat")
public class StatutController {

    private StatutParticipationService service;
    private StatutEnvoiServiceImpl service2;

    @PostMapping("/Ajouter/StatutParticipation")
    public StatutParticipation Ajout(@RequestBody StatutParticipation entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher/StatutParticipation")
    public List<StatutParticipation> Afficher(){
        return service.displayAll();
    }

    @DeleteMapping("/Supprimer/StatutParticipation/{id}")
    public String Sup(@PathVariable Long id){
        return service.delete(id);
    }

    @PostMapping("/Ajouter/StatutEnvoi")
    public StatutEnvoi Ajout(@RequestBody StatutEnvoi entity){
        return service2.Ajouter(entity);
    }

    @GetMapping("/Afficher/StatutEnvoi")
    public List<StatutEnvoi> Afficher1(){
        return service2.displayAll();
    }

    @DeleteMapping("/Supprimer/StatutEnvoi/{id}")
    public String Supp(@PathVariable Long id){
        return service2.delete(id);
    }

    @DeleteMapping("/SupprimerPlusieur/{id}")
    public String Sup(@PathVariable List<Long> id){
        return service.deleteMore(id);
    }

    @DeleteMapping("/SupprimerAll")
    public String Sup(){
        return service.deleteAll();
    }
}