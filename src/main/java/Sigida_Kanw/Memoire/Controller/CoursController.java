package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Cours;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.Implement.CoursService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("cours")
public class CoursController {

    private CoursService service;
    private ContexHolder contexHolder;

    @PostMapping("/Ajouter")
    public Cours Ajout(@RequestBody Cours cours){
        System.out.println("user : "+contexHolder.utilisateur());
        System.out.println("cours : " + cours);
        cours.setUtilisateur(contexHolder.utilisateur());
        return service.Ajouter(cours);
    }

    @GetMapping("Afficher")
    public List<Cours> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Cours MAJ(@PathVariable Long id, @RequestBody Optional<Cours> cours){
        return service.update(id,cours);
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
