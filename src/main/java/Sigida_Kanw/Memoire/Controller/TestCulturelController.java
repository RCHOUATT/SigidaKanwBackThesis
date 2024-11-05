package Sigida_Kanw.Memoire.Controller;/*package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.TestCulturel;
import Sigida_Kanw.Memoire.Service.Implement.TestCulturelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/testCulturel")
public class TestCulturelController {

    private TestCulturelService testCulturelService;

    @PostMapping("/AjouterTestCulturel")
    public TestCulturel Ajout(@RequestBody TestCulturel testCulturel){
        return testCulturelService.Ajouter(testCulturel);
    }

    @GetMapping("/AfficherTestCulturel")
    public List<TestCulturel> Afficher(){
        return testCulturelService.displayAll();
    }

    @DeleteMapping("/SupprimerTestCulturel/{id}")
    public String Sup(@PathVariable Long id){
        return testCulturelService.delete(id);
    }
}
*/