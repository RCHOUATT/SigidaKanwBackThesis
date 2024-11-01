package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Config.JwtTokenProvider;
import Sigida_Kanw.Memoire.Model.LoginDto;
import Sigida_Kanw.Memoire.Model.Utilisateur;
import Sigida_Kanw.Memoire.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private Utilisateur_repo userRepository; // Repository pour accéder aux utilisateurs

    @Override
    public String login(LoginDto loginDto) {

        // Récupérer l'utilisateur via son nom d'utilisateur ou email
        Utilisateur user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec ce nom ou email"));

        // Vérifier si l'utilisateur est actif
//        if (!user.isActive()) {
//            throw new IllegalArgumentException("Votre compte est désactivé.");
//        }

        // Authentifier l'utilisateur
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        // Si l'authentification réussit, générer le token
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }
}
