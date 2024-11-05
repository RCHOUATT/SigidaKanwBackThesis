package Sigida_Kanw.Memoire.Controller;


import Sigida_Kanw.Memoire.Model.Defis;
import Sigida_Kanw.Memoire.Service.Implement.DefisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("defis")
public class DefisController{

    private DefisService service;

    @PostMapping("/Ajouter")
    public Defis Ajout(@RequestBody Defis entity){
        return service.Ajouter(entity);
    }


    @GetMapping("/Afficher")
    public List<Defis> Afficher(){
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
    public Defis update(@PathVariable Long id, @RequestBody Defis entity){
        return service.update(id, entity);
    };
}
