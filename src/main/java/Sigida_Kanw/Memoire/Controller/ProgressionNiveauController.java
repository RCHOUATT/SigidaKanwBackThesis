package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ProgressionNiveau;
import Sigida_Kanw.Memoire.Service.Implement.ProgressionNiveauService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/progressionNiveau")
public class ProgressionNiveauController {

    private ProgressionNiveauService service;

    @PostMapping("/Ajouter")
    public ProgressionNiveau Ajout(@RequestBody ProgressionNiveau entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<ProgressionNiveau> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public ProgressionNiveau MAJ(@PathVariable Long id, @RequestBody ProgressionNiveau entity){
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