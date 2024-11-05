package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Progression;
import Sigida_Kanw.Memoire.Model.ProgressionCours;
import Sigida_Kanw.Memoire.Model.ProgressionNiveau;
import Sigida_Kanw.Memoire.Service.Implement.ProgressionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/progression")
public class ProgressionController {

    private ProgressionService service;

    @PostMapping("/Ajouter/ProgressionCours")
    public ProgressionCours Ajout(@RequestBody ProgressionCours entity) throws Exception{
        return service.AjouterProgressionCours(entity);
    }

    @PostMapping("/Ajouter/ProgressionNiveau")
    public ProgressionNiveau Ajout(@RequestBody ProgressionNiveau entity) throws Exception{
        return service.AjouterProgressionNiveau(entity);
    }

    @GetMapping("/Afficher")
    public List<Progression> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Progression MAJ(@PathVariable Long id, @RequestBody ProgressionNiveau entity){
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