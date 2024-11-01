package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Chapitre;
import Sigida_Kanw.Memoire.Repository.CoursRepo;
import Sigida_Kanw.Memoire.Service.Implement.ChapitreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("chapitre")
public class ChapitreController {

    private ChapitreService service;
    private CoursRepo coursRepo;

    @PostMapping("/Ajouter")
    public Chapitre Ajout(@RequestBody Chapitre entity){
        return service.Ajouter(entity);
    }

    @GetMapping("Afficher")
    public List<Chapitre> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Chapitre MAJ(@PathVariable Long id, @RequestBody Chapitre entity){
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