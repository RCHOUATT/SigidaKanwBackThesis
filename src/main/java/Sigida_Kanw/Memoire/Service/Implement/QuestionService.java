package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Model.Question;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService extends CrudService<Question, Long> {

    private FilesService filesService;
    public QuestionService(FilesService filesService, JpaRepository<Question, Long> generalRepo) {
        super(generalRepo);
        this.filesService = filesService;
    }

    public Question creerQuestion(Question question, List<MultipartFile> files) throws Exception {
        List<Files> filesList = new ArrayList<>();
        if (question !=null && !files.isEmpty()) {
            for (MultipartFile file: files) {
                try {
                    Files file1= filesService.AjouterFile(file);
                    filesList.add(file1);
                    question.setFiles(filesList);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return generalRepo.save(question);
    }

    public Question updateQuestion(Long id, Question entity, List<MultipartFile> files) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            List<Files> filesList = new ArrayList<>();
                            if (files != null) {
                                for (MultipartFile file: files) {
                                    try {
                                        Files file1= filesService.AjouterFile(file);
                                        filesList.add(file1);
                                        p.setFiles(filesList);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                            if (entity.getQuestion() != null){
                                p.setQuestion(entity.getQuestion());
                            }
                            /*if (entity.getTypeQuestion() != null){
                                p.setTypeQuestion(entity.getTypeQuestion());
                            }*/
                            if (entity.getReponseCorrecte() != null){
                                p.setReponseCorrecte(entity.getReponseCorrecte());
                            }
                            if (entity.getTest() != null){
                                p.setTest(entity.getTest());
                            }
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }

}