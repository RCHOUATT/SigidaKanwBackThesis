package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.TypeCours;
import Sigida_Kanw.Memoire.Service.Implement.TypeCoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/typeCours")
@CrossOrigin(origins = "http://localhost:4200")
public class TypeCoursController {

    private TypeCoursService service;

    @PostMapping("/Ajouter")
    public TypeCours Ajout(@RequestBody TypeCours entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<TypeCours> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public TypeCours MAJ(@PathVariable Long id, @RequestBody TypeCours entity){
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