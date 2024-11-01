package Sigida_Kanw.Memoire.Security;

import Sigida_Kanw.Memoire.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailServiceConfig implements UserDetailsService {

    private Utilisateur_repo utilisateur_repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateur_repo.findByEmail(username).orElseThrow();
    }

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("hello");
        Optional<Utilisateur> utilisateur = utilisateur_repo.findByEmail(email);
        System.out.println("helloAlpha");
        if (utilisateur.isPresent()) {
            System.out.println("helloAlpha2");
            System.out.println(utilisateur.get().getRole().getRole());
            System.out.println(utilisateur.get().getEmail());
            System.out.println(utilisateur.get().getMdp());
        }
        System.out.println("helloAlpha1");
        return User
                .withUsername(utilisateur.get().getEmail())
                .password(utilisateur.get().getMdp())
                .roles(utilisateur.get().getRole().getRole())
                .build();
    }*/


}
