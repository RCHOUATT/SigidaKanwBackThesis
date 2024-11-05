package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Contenu;
import Sigida_Kanw.Memoire.Service.Implement.ContenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("contenu")
public class ContenuController {

    private ContenuService service;
    private ObjectMapper objectMapper;


    @PostMapping("/AjouterContenu")
    public Contenu Ajout(@RequestBody Contenu entity){
        return service.Ajouter(entity);
    }

    @PostMapping("/creer")
    public ResponseEntity<String> creer(
            @RequestPart("entity") String contenuJson,
            @RequestPart("fichiers") List<MultipartFile> fichiers) {

        try {
            Contenu contenu1 = objectMapper.readValue(contenuJson, Contenu.class);
            String response = service.creerContenu(contenu1, fichiers);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création du contenu : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Afficher")
    public List<Contenu> Afficher(){
        return service.displayAll();
    }

    @DeleteMapping("/Supprimer/{id}")
    public String Sup(@PathVariable Long id){
        return service.delete(id);
    }

    @PatchMapping("Modifier/{id}")
    public ResponseEntity<Contenu> update(
            @PathVariable Long id,
            @RequestParam("contenu") String contenuJson,
            @RequestParam(value = "fichiers", required = false) List<MultipartFile> fichiers) throws Exception {

            Contenu contenu1 = objectMapper.readValue(contenuJson, Contenu.class);
            Contenu response = service.update(id, contenu1, fichiers);

            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
