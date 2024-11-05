package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.DemandeSupport;
import Sigida_Kanw.Memoire.Service.Implement.DemandeSupportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/DemandeSupport")
public class DemandeSupportControler{

    private DemandeSupportService service;

    @PostMapping("/Ajouter")
    public DemandeSupport Ajout(@RequestBody DemandeSupport entity){
        return service.Ajouter(entity);
    }


    @GetMapping("/Afficher")
    public List<DemandeSupport> Afficher(){
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
    public DemandeSupport update(@PathVariable Long id, @RequestBody DemandeSupport entity){
        return service.update(id, entity);
    };
}
