package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.StatsApprenant;
import Sigida_Kanw.Memoire.Service.StatsApprenantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/stat")
public class StatsController{

    private StatsApprenantService service;

    @GetMapping("/Afficher")
    public List<StatsApprenant> Afficher(){
        return service.Affiche();
    }

    @PutMapping("Modifier/{id}")
    public StatsApprenant MAJ(@PathVariable Long id, @RequestBody StatsApprenant statsApprenant){
        return service.MAJ(id,statsApprenant);
    }

    @DeleteMapping("/SupprimerStatApprenant/{id}")
    public String Sup(@PathVariable Long id){
        return service.Supp(id);
    }

}