package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Pays;
import Sigida_Kanw.Memoire.Service.Implement.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pays")
public class PaysController {

    private PaysService service;

    @PostMapping("/Ajouter")
    public Pays Ajout(@RequestBody Pays entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<Pays> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Pays MAJ(@PathVariable Long id, @RequestBody Pays entity){
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