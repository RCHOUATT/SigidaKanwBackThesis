package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.HistoriqueQuiz;
import Sigida_Kanw.Memoire.Service.HistoriqueQuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/HistoriqueQuiz")
public class HistotiqueQuizController {

    private HistoriqueQuizService service;

    @PostMapping("/Ajouter")
    public HistoriqueQuiz Ajout(@RequestBody HistoriqueQuiz statutBillet){
        return service.Ajout(statutBillet);
    }

    @GetMapping("/Afficher")
    public List<HistoriqueQuiz> Afficher(){
        return service.Affiche();
    }

    @PutMapping("Modifier/{id}")
    public HistoriqueQuiz MAJ(@PathVariable Long id, @RequestBody HistoriqueQuiz historiqueQuiz){
        return service.MAJ(id,historiqueQuiz);
    }

    @DeleteMapping("/Supprimer/{id}")
    public String Sup(@PathVariable Long id){
        return service.Supp(id);
    }
}
