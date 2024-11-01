package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.StatutDemande;
import Sigida_Kanw.Memoire.Service.Implement.StatutDemandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/statutDemande")
public class StatutDemandeController {

    private StatutDemandeService service;

    @PostMapping("/Ajouter")
    public StatutDemande Ajout(@RequestBody StatutDemande entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<StatutDemande> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public StatutDemande MAJ(@PathVariable Long id, @RequestBody StatutDemande entity){
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