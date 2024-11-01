package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Langue;
import Sigida_Kanw.Memoire.Service.Implement.LangueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/langue")
public class LangueController {

    private LangueService service;

    public LangueController(LangueService service) {
        this.service = service;
    }

    @PostMapping("/Ajouter")
    public Langue Ajout(@RequestBody Langue entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<Langue> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public Langue MAJ(@PathVariable Long id, @RequestBody Langue entity){
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
