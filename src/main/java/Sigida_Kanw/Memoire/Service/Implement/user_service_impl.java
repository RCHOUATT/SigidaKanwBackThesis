package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.*;
import Sigida_Kanw.Memoire.Repository.*;
import Sigida_Kanw.Memoire.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class user_service_impl implements Utilisateur_service {

    private PasswordEncoder passwordEncoder;
    private Utilisateur_repo utilisateurRepo;
    private RoleUserRepo roleUserRepo;
    private MediaRepository mediaRepository;
    private StatsApprenantRepo statsApprenantRepo;
    private NiveauEtudesRepo niveauEtudesRepo;
    private FilesService filesService;
    private ActiviteUtilisateurRepo activiteUtilisateurRepo;

    @Override
    public Apprenant creerApprenant(Apprenant apprenant, Optional<MultipartFile> image) throws Exception {
        Files files = null; // Définir les fichiers comme null initialement

        // Si l'image est présente, l'ajouter
        if (image.isPresent()) {
            files = filesService.AjouterFile(image.get());
        }

        apprenant.setRole(roleUserRepo.findByRole("APPRENANT"));
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));

        // Associer les fichiers seulement s'ils existent
        if (files != null) {
            apprenant.setFiles(files);
        }

        Apprenant user = utilisateurRepo.save(apprenant);

        StatsApprenant statsApprenant = StatsApprenant.builder()
                .niveau(niveauEtudesRepo.findByNiveau("DEBUTANT"))
                .point(0)
                .piece(0)
                .build();
        statsApprenantRepo.save(statsApprenant);
        ActiviteUtilisateur userActivity = ActiviteUtilisateur.builder()
                .dateUtilisation(Instant.now())
                .utilisateur(user)
                .build();

        activiteUtilisateurRepo.save(userActivity);
        return user;
    }


    @Override
    public Formateur creerFormateur(Formateur formateur, Optional<MultipartFile> image) throws Exception {

        Files files = null;
        System.out.println("a");
        if (image.isPresent()) {
            System.out.println("a");
            files = filesService.AjouterFile(image.get());
        }
        System.out.println("a");
        RoleUser roleUser = roleUserRepo.findByRole("FORMATEUR");
        formateur.setRole(roleUser);
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));

        // Associer les fichiers seulement s'ils existent
        if (files != null) {
            formateur.setFiles(files);
        }
        //mediaRepository.save(files);
        Formateur user = utilisateurRepo.save(formateur);
        ActiviteUtilisateur userActivty = ActiviteUtilisateur.builder()
                .dateUtilisation(Instant.now())
                .utilisateur(user)
                .build();
        activiteUtilisateurRepo.save(userActivty);
        return user;
    }

    @Override
    public Admin createAdmin(Admin admin, Optional<MultipartFile> image) throws Exception {

        Files files = null;

        if (image.isPresent()) {
            files = filesService.AjouterFile(image.get());
        }

        RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
        admin.setRole(roleUser);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        if (image.isPresent()) {
            admin.setFiles(files);
        }
        //mediaRepository.save(files);
        Admin user = utilisateurRepo.save(admin);
        ActiviteUtilisateur userActivty = ActiviteUtilisateur.builder()
                .dateUtilisation(Instant.now())
                .utilisateur(user)
                .build();
        activiteUtilisateurRepo.save(userActivty);
        return user;
    }

    @Override
    public List<Utilisateur> displayAll() {
        return utilisateurRepo.findAll();
    }

    @Override
    public Utilisateur display(Long id) {
        return utilisateurRepo.findById(id).get();
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateur, Optional<MultipartFile> files) {
        return utilisateurRepo.findById(id)
                .map(
                        p->{
                            if (files.isPresent()) {
                                Files file1= null;
                                try {
                                    file1 = filesService.AjouterFile(files.get());
                                    p.setFiles(file1);
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
                            return utilisateurRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }


    @Override
    public String delete(Long id) {
        utilisateurRepo.deleteById(id);
        return "Utilisateur éffacé avec succès";
    }

    @Override
    public List<Utilisateur> listeParNom(String nom) {
        return utilisateurRepo.findByNom(nom);
    }

    @Override
    public Utilisateur findByEmail(String password) {
        return utilisateurRepo.findByEmail(password).orElse(null);
    }

    //modifier profil
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur); // Assurez-vous que votre repository étend JpaRepository
    }

}
