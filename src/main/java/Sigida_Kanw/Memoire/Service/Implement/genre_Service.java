package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.GenreUser;
import Sigida_Kanw.Memoire.Repository.GenreUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class genre_Service {
    private GenreUserRepo genreUserRepo;

    // Ajouter un nouveau rôle
    public GenreUser AjouterRole(GenreUser genre) {
        return genreUserRepo.save(genre);
    }

    // Obtenir la liste de tous les rôles
    public List<GenreUser> ListeRole() {
        return genreUserRepo.findAll();
    }

    // Supprimer un rôle par son ID
    public String supprimer(Long id) {
        Optional<GenreUser> roleOptional = genreUserRepo.findById(id);
        if (roleOptional.isPresent()) {
            genreUserRepo.deleteById(id);
            return "Role supprimé avec succès";
        } else {
            return "Role non trouvé";
        }
    }

    // Modifier un rôle existant
    public GenreUser Modifier(Long id, GenreUser role) {
        if (genreUserRepo.existsById(id)) {
            role.setId(id);
            return genreUserRepo.save(role);
        } else {
            throw new RuntimeException("Role non trouvé avec l'ID: " + id);
        }
    }

    public String deleteAll(){
        genreUserRepo.deleteAll();
        return "Suppression reussite avec succès";
    };

    public String deleteMore(List<Long > id){
        id.forEach(e->{
            genreUserRepo.deleteById(e);
        });
        return "Suppression reussite avec succès";
    };
}
