package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ParticipationDefi;
import Sigida_Kanw.Memoire.Service.Implement.ParticipationDefiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/participationDefis")
public class ParticipationDefiController {

    private ParticipationDefiService service;

    @PostMapping("/Ajouter")
    public ParticipationDefi Ajout(@RequestBody ParticipationDefi entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<ParticipationDefi> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public ParticipationDefi MAJ(@PathVariable Long id, @RequestBody ParticipationDefi entity){
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
