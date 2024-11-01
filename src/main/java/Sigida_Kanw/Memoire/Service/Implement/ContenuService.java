package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Contenu;
import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContenuService extends CrudService<Contenu, Long> {

    private FilesService filesService;

    public ContenuService(FilesService filesService, JpaRepository<Contenu, Long> generalRepo) {
        super(generalRepo);
        this.filesService = filesService;
    }

    public String creerContenu(Contenu contenu, List<MultipartFile> files) throws Exception {
        List<Files> filesList = new ArrayList<>();
        if (contenu !=null && !files.isEmpty()) {
            for (MultipartFile file: files) {
                try {
                    Files file1= filesService.AjouterFile(file);
                    filesList.add(file1);
                    contenu.setFiles(filesList);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        generalRepo.save(contenu);
        return "Ajout réussi avec succès";
    }

    public Contenu update(Long id, Contenu entity, List<MultipartFile> files) {
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
                    if (entity.getDescription() != null){
                        p.setDescription(entity.getDescription());
                    }
                    if (entity.getTitre() != null){
                        p.setTitre(entity.getTitre());
                    }
                    if (entity.getChapitre() != null){
                        p.setChapitre(entity.getChapitre());
                    }
                    return generalRepo.save(p);
                }
            ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
