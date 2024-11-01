package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.StatutEnvoi;
import Sigida_Kanw.Memoire.Service.Implement.StatutEnvoiServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/statutEnvoi")
public class StatutEnvoiController {

    private StatutEnvoiServiceImpl service;

    @PostMapping("/Ajouter")
    public StatutEnvoi Ajout(@RequestBody StatutEnvoi entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<StatutEnvoi> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public StatutEnvoi MAJ(@PathVariable Long id, @RequestBody StatutEnvoi entity){
        return service.MAJ(id,entity);
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