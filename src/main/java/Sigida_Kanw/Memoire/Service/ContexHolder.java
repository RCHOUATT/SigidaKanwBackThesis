package Sigida_Kanw.Memoire.Service;

import Sigida_Kanw.Memoire.Model.Utilisateur;
import Sigida_Kanw.Memoire.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContexHolder {

    private Utilisateur_repo utilisateur_repo;

    public Utilisateur utilisateur() {
        Object main = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (main instanceof UserDetails) {
            username = ((UserDetails)main).getUsername();
            utilisateur_repo.findByEmail(username);
        }else{
            username = main.toString();
        }
        return utilisateur_repo.findByEmail(username).get();
    }
}
