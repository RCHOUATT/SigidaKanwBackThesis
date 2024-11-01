package Sigida_Kanw.Memoire.Controller;/*package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.*;
import Sigida_Kanw.Memoire.Service.Implement.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/typeQuestion")
public class TypeQuestionsController {

    private TypeQuestionsService service;

    @PostMapping("/Ajouter")
    public TypeQuestion Ajout(@RequestBody TypeQuestion entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<TypeQuestion> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modidier/{id}")
    public TypeQuestion MAJ(@PathVariable Long id, @RequestBody TypeQuestion entity){
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
}*/