package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ReponsePossible;
import Sigida_Kanw.Memoire.Service.Implement.ReponsePossibleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("reponsePossible")
public class ReponsePossibleController {

    private ReponsePossibleService service;

    @PostMapping("/Ajouter")
    public ReponsePossible Ajout(@RequestBody ReponsePossible entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<ReponsePossible> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public ReponsePossible MAJ(@PathVariable Long id, @RequestBody ReponsePossible entity){
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