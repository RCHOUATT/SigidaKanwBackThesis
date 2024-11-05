package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.TypeTest;
import Sigida_Kanw.Memoire.Service.Implement.TypeTestsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/typeTests")
public class TypeTestsController {

    private TypeTestsService service;

    @PostMapping("/Ajouter")
    public TypeTest Ajout(@RequestBody TypeTest entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<TypeTest> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public TypeTest MAJ(@PathVariable Long id, @RequestBody TypeTest entity){
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