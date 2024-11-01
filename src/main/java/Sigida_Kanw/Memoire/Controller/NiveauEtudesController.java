package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.NiveauEtudes;
import Sigida_Kanw.Memoire.Service.Implement.NiveauEtudesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/niveauEtudes")
public class NiveauEtudesController {

    private NiveauEtudesService service;

    @PostMapping("/Ajouter")
    public NiveauEtudes Ajout(@RequestBody NiveauEtudes entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<NiveauEtudes> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public NiveauEtudes MAJ(@PathVariable Long id, @RequestBody NiveauEtudes entity){
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
