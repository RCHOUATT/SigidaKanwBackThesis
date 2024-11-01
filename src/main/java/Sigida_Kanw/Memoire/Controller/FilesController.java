package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Service.Implement.FilesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/files")
public class FilesController{

    private FilesService service;

    @PostMapping(value = "uploadFiles", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Files fichier = service.AjouterFile(file);
        return ResponseEntity.ok("Fichier uploadé avec succès. ID du fichier : " + fichier.getUrl());
    }

    @PatchMapping(value = "Modifier/{url}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateFile(@RequestParam("file") MultipartFile fichier, @PathVariable String url) throws Exception {
        Files newfichier = service.updateFile(url, fichier);
        return ResponseEntity.ok("Fichier modifié avec succès. ID du fichier : " + newfichier.getUrl());
    }

    @GetMapping("/AfficherFiles")
    public List<Files> AfficherAll(){
        return service.displayAll();
    }

    @GetMapping("/AfficherFile")
    public Files Afficher(Long Id){
        return service.display(Id);
    }

    @DeleteMapping("/delete/{fileId}")
    public String deleteFile(@PathVariable Long fileId) throws Exception {
        try {
            return service.suppFile(fileId);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors de la suppression du fichier: " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteAll/{adresse}")
    public String deleteAllFiles(@PathVariable String adresse) throws Exception {
        try {
            service.deleteAll(adresse);
            return "Tous les fichiers sont supprimes avec succes.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors du nettoyage: " + e.getMessage();
        }
    }
}
