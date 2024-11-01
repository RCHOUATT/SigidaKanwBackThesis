package Sigida_Kanw.Memoire.Service.Implement;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorage {

    // Dossiers de destination pour les fichiers
     // Dossier pour les PDF
    private final String lien = "http://localhost:8081/sigidaKanw";  // URL publique pour le frontend

    // Méthode générique pour sauvegarder un fichier
    public String upload(MultipartFile fichier, String dossier, String type) throws IOException {
        // Vérifie si le dossier de destination existe, sinon le créer
        Path cheminDossier = Paths.get(dossier);
        System.out.println(dossier);
        System.out.println(cheminDossier);


        if (!Files.exists(cheminDossier)) {
            Files.createDirectories(cheminDossier);
        }

        // Vérifie que le fichier n'est pas vide et a un nom valide
        String nomFichier = fichier.getOriginalFilename();
        System.out.println(nomFichier);

        if (nomFichier == null || nomFichier.isEmpty()) {
            throw new IOException("Le nom du fichier est invalide.");
        }

        System.out.println("e");

        // Génère un nom de fichier unique pour éviter les conflits
        String extension = getFileExtension(nomFichier);
        String nomFichierUnique = UUID.randomUUID().toString() + "." + extension;
        Path cheminFichier = cheminDossier.resolve(nomFichierUnique);

        // Sauvegarde le fichier sur le disque
        Files.copy(fichier.getInputStream(), cheminFichier);

        System.out.println("e");
        // Retourne l'URL du fichier sauvegardé pour le frontend
        System.out.println("upload return link : " + lien + "/" + dossier + nomFichierUnique);
        return lien + "/" + dossier + nomFichierUnique;
    }

    // Vérifie que l'extension du fichier est valide pour les fichiers texte
    private boolean isValidTextFile(String nomFichier) {
        String extension = getFileExtension(nomFichier).toLowerCase();
        return extension.equals("txt") || extension.equals("pdf");
    }

    // Vérifie que l'extension du fichier est valide pour les fichiers PDF
    private boolean isValidPDFFile(String nomFichier) {
        String extension = getFileExtension(nomFichier).toLowerCase();
        return extension.equals("pdf");
    }

    // Supprimer un fichier (basé sur l'URL sauvegardée)
    public void deleteFileByUrl(String fileUrl) throws IOException {
        // Supprime le préfixe de l'URL pour obtenir le chemin relatif
        String relativePath = fileUrl.replace(lien + "/", "");
        Path cheminFichier = Paths.get(relativePath);

        // Supprimer le fichier si présent
        Files.deleteIfExists(cheminFichier);
    }

    public void deleteFilesInDirectory(String directory) throws IOException {
        Path cheminDossier = Paths.get(directory);
        if (Files.exists(cheminDossier)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(cheminDossier)) {
                for (Path filePath : stream) {
                    Files.deleteIfExists(filePath);
                }
            }
        }
    }

    public String replaceFile(String fileUrl, MultipartFile nouveauFichier) throws IOException {
        // Supprime l'ancien fichier
        deleteFileByUrl(fileUrl);

        // Déduit le type du fichier à partir de son URL
        String dossier;
        String type;
        if (fileUrl.contains("audio")) {
            dossier = "audio";
            type = "audio";
        } else if (fileUrl.contains("image")) {
            dossier = "image";
            type = "image";
        } else if (fileUrl.contains("video")) {
            dossier = "video";
            type = "video";
        } else {
            throw new IOException("Le dossier de destination est introuvable pour l'URL fournie.");
        }

        // Enregistre le nouveau fichier au même emplacement
        return upload(nouveauFichier, dossier, type);
    }

    // Vérifie si le fichier vidéo a une extension valide
    private boolean isValidVideoFile(String nomFichier) {
        String extension = getFileExtension(nomFichier).toLowerCase();
        return extension.equals("mp4") || extension.equals("avi");
    }

    // Vérifie si le fichier image a une extension valide
    private boolean isValidImageFile(String nomFichier) {
        String extension = getFileExtension(nomFichier).toLowerCase();
        return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");
    }

    // Extrait l'extension du fichier
    private String getFileExtension(String nomFichier) {
        int lastIndexOfDot = nomFichier.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            throw new IllegalArgumentException("Le fichier ne semble pas avoir d'extension.");
        }
        return nomFichier.substring(lastIndexOfDot + 1);
    }
}
