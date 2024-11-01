package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.Apprenant;
import Sigida_Kanw.Memoire.Model.Files;
import Sigida_Kanw.Memoire.Model.Langue;
import Sigida_Kanw.Memoire.Repository.ApprenantRepo;
import Sigida_Kanw.Memoire.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ApprenantService{

    private PasswordEncoder passwordEncoder;
    private Utilisateur_repo utilisateurRepo;
    private FilesService filesService;
    private ApprenantRepo apprenantRepo;

    public Apprenant update(Long id, Apprenant utilisateur, Optional<MultipartFile> files) {
        return apprenantRepo.findById(id)
                .map(
                        p->{
                            if (files.isPresent()) {
                                try {
                                    Files fileUrl = filesService.AjouterFile(files.get());
                                    p.setFiles(fileUrl);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (utilisateur.getNom() != null){
                                p.setNom(utilisateur.getNom());
                            }
                            if (utilisateur.getEmail() != null){
                                p.setEmail(utilisateur.getEmail());
                            }
                            if (utilisateur.getTelephone() != null){
                                p.setTelephone(utilisateur.getTelephone());
                            }
                            if (utilisateur.getPassword() != null){
                                p.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
                            }
                            if (utilisateur.getRole() != null){
                                p.setRole(utilisateur.getRole());
                            }
                            if (utilisateur.getLangues() != null) {
                                for (Langue langue : utilisateur.getLangues()) {
                                    // Vérifier si la langue est déjà dans le profil
                                    boolean existe = p.getLangues().stream()
                                            .anyMatch(l -> langue.getId() == l.getId());

                                    // Si elle n'existe pas, l'ajouter
                                    if (!existe) {
                                        p.addLangue(langue);
                                    }
                                }
                            }
                            return utilisateurRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }

}
