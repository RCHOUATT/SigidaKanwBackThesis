package Sigida_Kanw.Memoire.Security;/*package Sigida_Kanw.Memoire.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    //private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailServiceConfig userDetail;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)  // Désactiver CSRF car on utilise des tokens JWT
                .cors(Customizer.withDefaults())  // Permettre CORS avec les paramètres par défaut
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/niveauEtudes/**", "/cours/**").hasRole("ADMIN")  // Routes accessibles sans authentification
                        .anyRequest().authenticated()  // Toute autre requête nécessite une authentification
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Utilisation de JWT, donc pas de session d'état
                )
                .authenticationProvider(authenticationProvider())  // Configuration du fournisseur d'authentification
                //.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)  // Ajouter le filtre JWT avant le filtre d'authentification par défaut
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetail);  // Utiliser UserDetailService personnalisé
        authProvider.setPasswordEncoder(passwordEncoder());  // Définir l'encodeur de mot de passe
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Encodeur de mot de passe avec BCrypt
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();  // Gestionnaire d'authentification personnalisé
    }
}
*/