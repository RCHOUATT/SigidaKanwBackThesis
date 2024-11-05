package Sigida_Kanw.Memoire.Config;//package com.savory.malisavory.config;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    @Value("${app.jwt-secret}")
//    private String jwtSecret;
//
//    @Value("${app.jwt-expiration-milliseconds}")
//    private long jwtExpirationDate;
//
//    // generate JWT token
//    public String generateToken(Authentication authentication) {
//
//        String username = authentication.getName();
//
//        Date currentDate = new Date();
//
//        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
//
//        String token = Jwts.builder()
//                .subject(username)
//                .issuedAt(new Date())
//                .expiration(expireDate)
//                .signWith(key())
//                .compact();
//
//        return token;
//    }
//
//    private Key key() {
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
//    }
//
//    // get username from JWT token
//    public String getUsername(String token) {
//
//        return Jwts.parser()
//                .verifyWith((SecretKey) key())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//    }
//
//    // validate JWT token
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(key())  // Utilisez setSigningKey pour passer la clé
//                    .build()
//                    .parseClaimsJws(token);  // Parse uniquement les Claims du JWT
//
//            return true;
//        } catch (Exception e) {
//            // Gérer les exceptions telles que SignatureException, ExpiredJwtException, etc.
//            return false;
//        }
//    }
//}

import Sigida_Kanw.Memoire.Model.Utilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    public String generateToken(Authentication authentication) {
        // Obtenez l'utilisateur personnalisé
        Utilisateur userDetails = (Utilisateur) authentication.getPrincipal();
        Long userId = userDetails.getId(); // Obtenez l'ID de l'utilisateur
        String userRole = userDetails.getRole().getRole(); // Obtenez l'ID de l'utilisateur

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(userDetails.getUsername()) // Utilisez le nom d'utilisateur
                .claim("userId", userId) // Ajoutez l'ID de l'utilisateur dans les claims
                .claim("role", userRole) // Ajoutez l'ID de l'utilisateur dans les claims
                .setIssuedAt(currentDate) // Date actuelle
                .setExpiration(expireDate) // Date d'expiration
                .signWith(key()) // Signature du jeton
                .compact();

        return token;
    }


    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // Get username from JWT token
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key()) // Utiliser parserBuilder() correctement
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Long getUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userId", Long.class); // Récupérez l'ID de l'utilisateur à partir des claims
    }

    public String getUserRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class); // Récupérez l'ID de l'utilisateur à partir des claims
    }


    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key()) // Utiliser setSigningKey()
                    .build()
                    .parseClaimsJws(token); // Parse uniquement les Claims du JWT
            return true;
        } catch (Exception e) {
            // Gérer les exceptions comme SignatureException, ExpiredJwtException, etc.
            return false;
        }
    }
}
