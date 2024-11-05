package Sigida_Kanw.Memoire.Service;

import Sigida_Kanw.Memoire.Model.Admin;
import Sigida_Kanw.Memoire.Model.Apprenant;
import Sigida_Kanw.Memoire.Model.Formateur;
import Sigida_Kanw.Memoire.Model.Utilisateur;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface Utilisateur_service{

    Apprenant creerApprenant(Apprenant apprenant, Optional<MultipartFile> image) throws Exception;
    Formateur creerFormateur(Formateur formateur, Optional<MultipartFile> image) throws Exception ;
    Admin createAdmin(Admin admin, Optional<MultipartFile> image) throws Exception;
    List<Utilisateur> displayAll() ;
    Utilisateur display(Long id);
    Utilisateur update(Long id,Utilisateur utilisateur, Optional<MultipartFile> image);
    String delete(Long id);
    List<Utilisateur> listeParNom(String nom);

    Utilisateur findByEmail(String username);
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
}
