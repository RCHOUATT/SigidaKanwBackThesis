package Sigida_Kanw.Memoire.Controller;//package com.savory.malisavory.controllers;
//
//import com.savory.malisavory.models.JwtAuthResponse;
//import com.savory.malisavory.models.LoginDto;
//import com.savory.malisavory.services.AuthService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private AuthService authService;
//
//    // Build Login REST API
////    @PostMapping("/login")
////    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
////        String token = authService.login(loginDto);
////
////        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
////        jwtAuthResponse.setAccessToken(token);
////
////        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
////    }
//
//    @PostMapping("/login")
//    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
//        String token = authService.login(loginDto);
//
//        if (token == null) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);  // Renvoie une erreur si le token est nul
//        }
//
//        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
//        jwtAuthResponse.setAccessToken(token);
//
//        System.out.println("Generated Token: " + token);  // Vérification du token généré
//
//        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
//    }
//
//
//}

import Sigida_Kanw.Memoire.Model.ActiviteUtilisateur;
import Sigida_Kanw.Memoire.Model.JwtAuthResponse;
import Sigida_Kanw.Memoire.Model.LoginDto;
import Sigida_Kanw.Memoire.Repository.ActiviteUtilisateurRepo;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.Implement.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final ContexHolder contexHolder;
    private AuthService authService;
    private ActiviteUtilisateurRepo activiteUtilisateurRepo;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        try {
            String token = authService.login(loginDto);

            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
            jwtAuthResponse.setAccessToken(token);


            ActiviteUtilisateur userActivty = ActiviteUtilisateur.builder()
                    .dateUtilisation(Instant.now())
                    .utilisateur(contexHolder.utilisateur())
                    .build();
            activiteUtilisateurRepo.save(userActivty);

            return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Gérer l'exception si l'utilisateur est inactif
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Votre compte est désactivé.");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);  // Autres erreurs (mauvais mot de passe, etc.)
        }
    }
}
