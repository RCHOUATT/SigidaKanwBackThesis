package Sigida_Kanw.Memoire.Controller;/*package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.TestLingustique;
import Sigida_Kanw.Memoire.Service.Implement.TestLingustiqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/testLingustique")
public class TestLingustiqueController {

    private TestLingustiqueService service;

    @PostMapping("/AjouterTestLingustique")
    public TestLingustique Ajout(@RequestBody TestLingustique entity){
        return service.Ajouter(entity);
    }

    @GetMapping("/AfficherTestLingustique")
    public List<TestLingustique> Afficher(){
        return service.displayAll();
    }

    @DeleteMapping("/SupprimerTestLingustique/{id}")
    public String Sup(@PathVariable Long id){
        return service.delete(id);
    }
}
*/