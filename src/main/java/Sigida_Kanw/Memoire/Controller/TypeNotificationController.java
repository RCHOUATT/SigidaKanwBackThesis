package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.TypeNotification;
import Sigida_Kanw.Memoire.Service.Implement.TypeNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/typeNotification")
public class TypeNotificationController {

    private TypeNotificationService service;

    @PostMapping("/Ajouter")
    public TypeNotification Ajout(@RequestBody TypeNotification entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/Afficher")
    public List<TypeNotification> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modifier/{id}")
    public TypeNotification MAJ(@PathVariable Long id, @RequestBody TypeNotification entity){
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