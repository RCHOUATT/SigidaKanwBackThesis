package Sigida_Kanw.Memoire.Service.Implement;/*
package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.ContenuCulturel;
import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Repository.MediaRepository;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ContenuCulturelService extends CrudService<ContenuCulturel, Long> {

    private DriveService driveService;
    private MediaRepository mediaRepository;

    public ContenuCulturelService(JpaRepository<ContenuCulturel, Long> generalRepo, DriveService driveService, MediaRepository mediaRepository) {
        super(generalRepo);
        this.driveService = driveService;
        this.mediaRepository = mediaRepository;
    }

    public ContenuCulturel Ajouter(ContenuCulturel entity, Optional<MultipartFile> file) throws Exception{
        String fileId = driveService.uploadFile(file.get());
        Files files = Files.builder()
                .nom(file.get().getOriginalFilename())
                .type(file.get().getContentType())
                .idFile(fileId)
                .build();

        mediaRepository.save(files);
        entity.setFiles(files);
        return generalRepo.save(entity);
    };

    public ContenuCulturel update(Long id, ContenuCulturel entity) {
        return generalRepo.findById(id)
            .map(
                p->{
                    p.setTitre(entity.getTitre());
                    p.setDescription(entity.getDescription());
                    p.setCours(entity.getCours());
                    return generalRepo.save(p);
                }
            ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
*/
