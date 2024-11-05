package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Admin;
import Sigida_Kanw.Memoire.Model.Apprenant;
import Sigida_Kanw.Memoire.Model.Formateur;
import Sigida_Kanw.Memoire.Model.Utilisateur;
import Sigida_Kanw.Memoire.Security.UserDetailServiceConfig;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import Sigida_Kanw.Memoire.Service.Implement.ApprenantService;
import Sigida_Kanw.Memoire.Service.Utilisateur_service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "utilisateur")
public class utilisateurController {

    private Utilisateur_service utilisateur_service;
    private ContexHolder contexHolder;
    private ObjectMapper objectMapper;
    private UserDetailServiceConfig userDetailService;
    private ApprenantService apprenantService;



    @PostMapping(value = "inscrireApprenant", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Apprenant> creerApprenant(
            @RequestParam("apprenant") String apprenantJson,
            @RequestParam("image") Optional<MultipartFile> image) {
        try {
            // Désérialiser le JSON en objet Apprenant
            Apprenant user = objectMapper.readValue(apprenantJson, Apprenant.class);
            System.out.println("APPRENANT json : " + user);

            // Vérifier si une image a été téléchargée et afficher le nom du fichier
            image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));

            // Créer l'apprenant avec l'image (si elle existe)
            Apprenant newApprenant = utilisateur_service.creerApprenant(user, image);

            // Retourner la réponse avec le nouvel apprenant créé et un statut 201 Created
            return ResponseEntity.status(HttpStatus.CREATED).body(newApprenant);
        } catch (Exception e) {
            // Log des erreurs éventuelles
            System.err.println("Erreur lors de la création de l'apprenant : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




    @PostMapping(value = "inscrireUser/{role}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> creerUser(@PathVariable String role, @RequestParam("utilisateurJson") String utilisateurJson, @RequestParam("image") Optional<MultipartFile> image) {
        try {
            System.out.println(role);
            switch (role) {
                case "ADMIN" -> {
                    System.out.println("ADMIN");
                    Admin user = objectMapper.readValue(utilisateurJson, Admin.class);
                    System.out.println("admin json : " + user);
                    image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));
                    utilisateur_service.createAdmin(user, image);
                }
                case "FORMATEUR" -> {
                    System.out.println("FORMATEUR");
                    System.out.println(utilisateurJson);
                    Formateur user = objectMapper.readValue(utilisateurJson, Formateur.class);
                    System.out.println("FORMATEUR json : " + user);
                    image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));
                    utilisateur_service.creerFormateur(user, image);
                }
                case "APPRENANT" -> {
                    System.out.println("APPRENANT");
                    Apprenant user = objectMapper.readValue(utilisateurJson, Apprenant.class);
                    System.out.println("APPRENANT json : " + user);
                    image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));
                    utilisateur_service.creerApprenant(user, image);
                }
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur Ajouter Avec succés");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/Afficher")
    List<Utilisateur> displayUsers(){
        return utilisateur_service.displayAll();
    }

    @GetMapping("/login/{email}")
    UserDetails login(@PathVariable String email ){
        UserDetails userDetail = userDetailService.loadUserByUsername(email);
        System.out.println(contexHolder.utilisateur());
        return userDetail;
    }

    @GetMapping("/User/{id}")
    Utilisateur displayUser(@PathVariable Long id){
        return utilisateur_service.display(id);
    }

    @GetMapping("/TriParNom")
    List<Utilisateur> TrierByname(String nom){
        return utilisateur_service.listeParNom(nom);
    }

    @PatchMapping(value = "Modifier/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Utilisateur> UpdateUser(@PathVariable Long id, @RequestParam("utilisateur") String utilisateur, @RequestParam("image") Optional<MultipartFile> image) {
        try {
            Utilisateur user = objectMapper.readValue(utilisateur, Utilisateur.class);
            System.out.println("formateur json : " + user);

            image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));
            Utilisateur newUser = utilisateur_service.update(id, user, image);

            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(value = "ModifierApprenat/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<Apprenant> UpdateApprenant(@PathVariable Long id, @RequestParam("apprenant") String apprenant, @RequestParam("image") Optional<MultipartFile> image) {
            try {
                System.out.println("formateur json : " + apprenant);
                Apprenant user = objectMapper.readValue(apprenant, Apprenant.class);
                System.out.println("apprenant json : " + user);

                image.ifPresent(file -> System.out.println("Image Original Filename: " + file.getOriginalFilename()));
                Apprenant apprenantUpdate = apprenantService.update(id, user, image);

                return ResponseEntity.status(HttpStatus.CREATED).body(apprenantUpdate);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    @DeleteMapping("/deleteUser/{id}")
    public  String supprimerAdmin( @PathVariable Long id){
        return utilisateur_service.delete(id);
    }

    @GetMapping("/currentSession")
    public Utilisateur getCurrentUser() {
        return contexHolder.utilisateur();
    }

//    @PatchMapping("/updateProfile")
//    public ResponseEntity<Utilisateur> updateProfile(@RequestBody Utilisateur updatedUser) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
//            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
//            Utilisateur currentUser = utilisateur_service.findByEmail(user.getUsername());
//
//            if (currentUser != null) {
//                currentUser.setNom(updatedUser.getNom());
//                currentUser.setEmail(updatedUser.getEmail());
//                currentUser.setTelephone(updatedUser.getTelephone());
//                // Ajoutez d'autres champs à mettre à jour si nécessaire
//
//                Utilisateur savedUser = utilisateur_service.updateUtilisateur(currentUser); // Assurez-vous que cette méthode existe
//                return ResponseEntity.ok(savedUser);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // ou une autre réponse appropriée
//    }

}
