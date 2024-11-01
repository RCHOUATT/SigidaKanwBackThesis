package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Repository.MediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class FilesService {

    private JpaRepository<Files, Long> generalRepo;
    private FileStorage service;
    private MediaRepository mediaRepository;

    public Files AjouterFile(MultipartFile file) throws Exception {

        // Télécharger le fichier dans le dossier créé
        System.out.println("b");
        String type = file.getContentType().split("/")[0];
        String url = "";
        System.out.println("b : " + type);
        if (type.equals("image")){
            url = service.upload(file, "resources/images_source/", type);
        } else if (type.equals("video")) {
            url = service.upload(file, "resources/audio_ressource/", type);
        }else if (type.equals("audio")) {
            url = service.upload(file, "resources/video_ressource/", type);
        }
        System.out.println("c : " + url);
        Files files = Files.builder()
                .type(file.getContentType())
                .url(url)
                .build();
        System.out.println("d");
        return generalRepo.save(files);
    }

    public String suppFile(Long id) throws Exception {
        return generalRepo.findById(id)
                .map(
                        p->{
                            try {
                                service.deleteFileByUrl(p.getUrl());
                                generalRepo.delete(p);
                                return "Suppression du fichier avec l'ID : "+p.getUrl()+" "+"avec succes";
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                ).orElseThrow(()->new Exception("Erreur lors de la mise à jour"));
    }

    public List<Files> displayAll() {
        return generalRepo.findAll();
    };

    public void deleteAll(String adresse) throws Exception {
        generalRepo.deleteAll();
        service.deleteFilesInDirectory(adresse);
    }

    public Files display(Long id){
        return generalRepo.findById(id).get();
    };

    public Files updateFile(String url, MultipartFile file) throws Exception {
        return mediaRepository.findByUrl(url).map(
                p -> {
                    String fileUrl;
                    try {
                        fileUrl = service.replaceFile(url, file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    p.setUrl(file.getContentType());
                    p.setUrl(fileUrl);
                    return mediaRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Erreur lors de la mise à jour"));
    }
}
