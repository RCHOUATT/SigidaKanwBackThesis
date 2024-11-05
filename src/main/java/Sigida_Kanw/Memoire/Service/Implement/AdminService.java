package Sigida_Kanw.Memoire.Service.Implement;/*package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.*;
import Sigida_Kanw.Memoire.Repository.*;
import Sigida_Kanw.Memoire.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService implements Utilisateur_service {

    private PasswordEncoder passwordEncoder;
    private Utilisateur_repo utilisateurRepo;
    private RoleUserRepo roleUserRepo;
    private DriveService driveService;
    private MediaRepository mediaRepository;
    private StatsApprenantRepo statsApprenantRepo;
    private NiveauEtudesRepo niveauEtudesRepo;
    private FilesService filesService;

    @Override
    public Apprenant creerApprenant(Apprenant apprenant, MultipartFile image) throws Exception {

        Files files = filesService.AjouterFile(image);

        StatsApprenant statsApprenant = StatsApprenant.builder()
                .niveau(niveauEtudesRepo.findByNiveau("DEBUTANT"))
                .point(0)
                .build();

        apprenant.setRole(roleUserRepo.findByRole("APPRENANT"));
        apprenant.setMdp(passwordEncoder.encode(apprenant.getMdp()));
        apprenant.setFiles(files);
        apprenant.setStats(statsApprenant);
        statsApprenantRepo.save(statsApprenant);
        return utilisateurRepo.save(apprenant);
    }

    @Override
    public Formateur CreerFormateur(Formateur formateur, MultipartFile image) throws Exception {

        Files files = filesService.AjouterFile(image);

        RoleUser roleUser = roleUserRepo.findByRole("FORMATEUR");
        formateur.setRole(roleUser);
        formateur.setMdp(passwordEncoder.encode(formateur.getMdp()));
        mediaRepository.save(files);
        return utilisateurRepo.save(formateur);
    }

    @Override
    public Admin createAdmin(Admin admin, MultipartFile image) throws Exception {

        Files files = filesService.AjouterFile(image);

        RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
        admin.setRole(roleUser);
        admin.setMdp(passwordEncoder.encode(admin.getMdp()));
        mediaRepository.save(files);
        return utilisateurRepo.save(admin);
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
    public Utilisateur update(Long id, Utilisateur utilisateur) {
        return utilisateurRepo.findById(id)
                .map(p->{
                    p.setNom(utilisateur.getNom());
                    p.setEmail(utilisateur.getEmail());
                    p.setTelephone(utilisateur.getTelephone());
                    //p.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
                    p.setRole(utilisateur.getRole());
                    return utilisateurRepo.save(p);
        }).orElseThrow(()-> new RuntimeException("Erreur lors de la mise à jour"));
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
*/