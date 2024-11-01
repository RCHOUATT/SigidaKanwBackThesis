package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.GenreUser;
import Sigida_Kanw.Memoire.Service.Implement.genre_Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/genre")
public class genreController {

    private genre_Service service;

    @PostMapping("/Ajouter")
    public GenreUser Ajout(@RequestBody GenreUser entity){
        return service.AjouterRole(entity);
    }

    @GetMapping("/Afficher")
    public List<GenreUser> Afficher(){
        return service.ListeRole();
    }

    @PatchMapping("/Modifier/{id}")
    public GenreUser MAJ(@PathVariable Long id, @RequestBody GenreUser entity){
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