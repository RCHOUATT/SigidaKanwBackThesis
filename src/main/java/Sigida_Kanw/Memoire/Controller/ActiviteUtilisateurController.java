package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.ActiviteUtilisateur;
import Sigida_Kanw.Memoire.Service.Implement.ActiviteUtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("activiteUtilisateur")
public class ActiviteUtilisateurController {

    private ActiviteUtilisateurService service;

    @PostMapping("/Ajouter")
    public ActiviteUtilisateur Ajout(@RequestBody ActiviteUtilisateur activiteUtilisateur){
        return service.Ajouter(activiteUtilisateur);
    }

    @GetMapping("/Afficher")
    public List<ActiviteUtilisateur> Afficher(){
        return service.displayAll();
    }

    @PatchMapping("/Modidier/{id}")
    public ActiviteUtilisateur MAJ(@PathVariable Long id, @RequestBody ActiviteUtilisateur historiqueQuiz){
        return service.update(id,historiqueQuiz);
    }

    @DeleteMapping("/Supprimer/{id}")
    public String Sup(@PathVariable Long id){
        return service.delete(id);
    }
}
