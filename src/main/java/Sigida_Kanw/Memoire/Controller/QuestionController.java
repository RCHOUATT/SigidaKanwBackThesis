package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Question;
import Sigida_Kanw.Memoire.Service.Implement.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("question")
public class QuestionController {

    private ObjectMapper objectMapper;
    private QuestionService service;

    @PostMapping("/Ajouter")
    public Question Ajout(@RequestBody Question entity){
        return service.Ajouter(entity);
    }

    @PostMapping("/creer")
    public ResponseEntity<Question> create(
            @RequestParam("entity") String questionson,
            @RequestParam(value = "fichiers", required = false) List<MultipartFile> fichiers) throws Exception {

            Question question1 = objectMapper.readValue(questionson, Question.class);
            Question response = service.creerQuestion(question1, fichiers);

            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/Modifier/{id}")
    public ResponseEntity<Question> update(
            @PathVariable Long id,
            @RequestParam("question") String questionJson,
            @RequestParam(value = "fichiers", required = false) List<MultipartFile> fichiers) throws Exception {

        Question question = objectMapper.readValue(questionJson, Question.class);
        Question response = service.updateQuestion(id, question, fichiers);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Afficher")
    public List<Question> Afficher(){
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
}