package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.RoleUser;
import Sigida_Kanw.Memoire.Service.Implement.Role_Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private Role_Service service;

    @PostMapping("/Ajouter")
    public RoleUser Ajout(@RequestBody RoleUser entity){
        return service.AjouterRole(entity);
    }

    @GetMapping("/Afficher")
    public List<RoleUser> Afficher(){
        return service.ListeRole();
    }

    @PatchMapping("/Modifier/{id}")
    public RoleUser MAJ(@PathVariable Long id, @RequestBody RoleUser entity){
        return service.Modifier(id,entity);
    }

    @DeleteMapping("/Supprimer/{id}")
    public String Sup(@PathVariable Long id){
        return service.supprimer(id);
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