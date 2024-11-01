package Sigida_Kanw.Memoire.dto;

import Sigida_Kanw.Memoire.Model.RoleUser;
import Sigida_Kanw.Memoire.Model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRep {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private String password;
    private RoleUser role;
    private Utilisateur utilisateur;
    private List<Utilisateur> utilisateursList;
}
