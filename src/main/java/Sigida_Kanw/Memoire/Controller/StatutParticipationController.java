package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.StatutParticipation;
import Sigida_Kanw.Memoire.Service.Implement.StatutParticipationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/statutParticipation")
public class StatutParticipationController {

    private StatutParticipationService service;

    @PostMapping("/Ajouter")
    public StatutParticipation Ajout(@RequestBody StatutParticipation entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<StatutParticipation> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public StatutParticipation MAJ(@PathVariable Long id, @RequestBody StatutParticipation entity){
        return service.update(id,entity);
    }

    @DeleteMapping("/Supprimer/{id}")
    public String Sup(@PathVariable Long id){
        return service.delete(id);
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