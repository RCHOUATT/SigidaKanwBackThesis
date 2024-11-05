package Sigida_Kanw.Memoire.Controller;/*
package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ContenuCulturel;
import Sigida_Kanw.Memoire.Service.Implement.ContenuCulturelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("contenuCulturel")
public class ContenuCulturelController {

    private ContenuCulturelService service;

    @PostMapping("/Ajouter")
    public ContenuCulturel Ajout(@RequestBody ContenuCulturel entity){
        return service.Ajouter(entity);
    }


    @GetMapping("/Afficher")
    public List<ContenuCulturel> Afficher(){
        return service.displayAll();
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

    @PatchMapping("/Modifier/{id}")
    public ContenuCulturel update(@PathVariable Long id, @RequestBody ContenuCulturel entity){
        return service.update(id, entity);
    };
}*/
