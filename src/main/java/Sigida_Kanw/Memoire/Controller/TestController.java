package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Test;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.Implement.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private TestService service;
    private ContexHolder contexHolder;

    @PostMapping("/Ajouter")
    public Test Ajout(@RequestBody Test entity){
        entity.setUtilisateur(contexHolder.utilisateur());
        return service.Ajouter(entity);
    }

    @GetMapping("Afficher")
    public List<Test> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Test MAJ(@PathVariable Long id, @RequestBody Optional<Test> entity){
        return service.update(id,entity.get());
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
