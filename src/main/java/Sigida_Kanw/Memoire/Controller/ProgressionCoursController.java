package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ProgressionCours;
import Sigida_Kanw.Memoire.Service.Implement.ProgressionCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/progressionCours")
public class ProgressionCoursController {

    private ProgressionCoursService service;

    @PostMapping("/Ajouter")
    public ProgressionCours Ajout(@RequestBody ProgressionCours entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<ProgressionCours> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public ProgressionCours MAJ(@PathVariable Long id, @RequestBody ProgressionCours entity){
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
