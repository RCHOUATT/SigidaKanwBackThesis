package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ProgressionLangues;
import Sigida_Kanw.Memoire.Service.Implement.ProgressionLanguesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/progressionLangues")
public class ProgressionLanguesController {

    private ProgressionLanguesService service;

    @PostMapping("/Ajouter")
    public ProgressionLangues Ajout(@RequestBody ProgressionLangues entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<ProgressionLangues> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public ProgressionLangues MAJ(@PathVariable Long id, @RequestBody ProgressionLangues entity){
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
