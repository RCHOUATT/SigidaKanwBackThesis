package Sigida_Kanw.Memoire;

import Sigida_Kanw.Memoire.Model.*;
import Sigida_Kanw.Memoire.Repository.*;
import Sigida_Kanw.Memoire.Service.Utilisateur_service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class MemoireApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoireApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner2(TypeCoursRepo typeCoursRepo, TypeTestRepo typeTestRepo, LangueRepo langueRepo) {
		return args -> {

			Langue langue1 = langueRepo.findByNom("SENOUFO");
			Langue langue = langueRepo.findByNom("BAMBARA");
			Langue langue2 = langueRepo.findByNom("PEULH");
			if (langue1 == null || langue == null || langue2 == null) {
				Langue langues = new Langue();
				Langue langues1 = new Langue();
				Langue langues2 = new Langue();
				langues.setNom("SENOUFO");
				langues1.setNom("BAMBARA");
				langues2.setNom("PEULH");
				langues.setApropos("Le sénoufo est une langue nigéro-congolaise parlée principalement en Côte d'Ivoire, au Mali et au Burkina Faso. Elle fait partie de la famille des langues mandé et est utilisée par les communautés sénoufo. Cette langue se distingue par sa richesse lexicale et ses tonalités variées.");
				langues1.setApropos("Le bambara est une langue mandé parlée principalement au Mali. C'est une langue véhiculaire largement utilisée dans le pays, avec une grammaire simple et un vocabulaire riche, influençant d'autres langues de la région. Les deux langues jouent un rôle essentiel dans la culture et l'identité de leurs locuteurs.");
				langues2.setApropos("Le bambara est une langue mandé parlée principalement au Mali. C'est une langue véhiculaire largement utilisée dans le pays, avec une grammaire simple et un vocabulaire riche, influençant d'autres langues de la région. Les deux langues jouent un rôle essentiel dans la culture et l'identité de leurs locuteurs.");
				langueRepo.save(langues);
				langueRepo.save(langues1);
				langueRepo.save(langues2);
			}

			TypeCours typeCours1 = typeCoursRepo.findByType("CULTUREL");
			TypeCours typeCours = typeCoursRepo.findByType("LINGUISTIQUE");
			if (typeCours1 == null || typeCours == null) {
				TypeCours typeCour = new TypeCours();
				typeCour.setType("CULTUREL");
				System.out.println("hello3");
				TypeCours typeCour1 = new TypeCours();
				typeCour1.setType("LINGUISTIQUE");
				System.out.println("hello3");
				typeCoursRepo.save(typeCour);
				typeCoursRepo.save(typeCour1);
			}

			TypeTest typeTest1 = typeTestRepo.findByType("CULTUREL");
			TypeTest typeTest = typeTestRepo.findByType("LINGUISTIQUE");
			if (typeTest1 == null || typeTest == null) {
				TypeTest typeTests = new TypeTest();
				typeTests.setType("CULTUREL");
				System.out.println("hello3");
				TypeTest typeTests1 = new TypeTest();
				typeTests1.setType("LINGUISTIQUE");
				System.out.println("hello3");
				typeTestRepo.save(typeTests);
				typeTestRepo.save(typeTests1);
			}
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner3(TypeNotificationRepo typeNotificationRepo,
												NiveauEtudesRepo niveauEtudesRepo,
												RoleUserRepo roleuserRepo,
												PasswordEncoder passwordEncoder,
												Utilisateur_repo utilisateurRepo,
												Utilisateur_service utilisateurService,
												RoleUserRepo roleUserRepo,
												GenreUserRepo genreUserRepo,
												PaysRepo paysRepo,
												MediaRepository mediaRepository
	) {
		return args -> {

			TypeNotification typeNotification1 = typeNotificationRepo.findByType("ALERTE");
			TypeNotification typeNotification = typeNotificationRepo.findByType("PERSONNALISER");
			if (typeNotification == null || typeNotification1 == null) {
				TypeNotification typeNotifications = new TypeNotification();
				typeNotifications.setType("ALERTE");
				System.out.println("hello3");
				TypeNotification typeNotifications1 = new TypeNotification();
				typeNotifications1.setType("PERSONNALISER");
				System.out.println("hello3");
				typeNotificationRepo.save(typeNotifications);
				typeNotificationRepo.save(typeNotifications1);
			}

			RoleUser roleUsers1 = roleuserRepo.findByRole("APPRENANT");
			RoleUser roleUsers = roleuserRepo.findByRole("ADMIN");
			RoleUser roleUsers2 = roleuserRepo.findByRole("FORMATEUR");
			if (roleUsers == null || roleUsers1 == null || roleUsers2 == null) {
				RoleUser roleUser = new RoleUser();
				roleUser.setRole("ADMIN");
				System.out.println("hello3");
				RoleUser roleUser1 = new RoleUser();
				roleUser1.setRole("APPRENANT");
				System.out.println("hello3");
				RoleUser roleUser2 = new RoleUser();
				roleUser2.setRole("FORMATEUR");
				roleuserRepo.save(roleUser);
				roleuserRepo.save(roleUser1);
				roleuserRepo.save(roleUser2);
			}

			GenreUser genreUsers = genreUserRepo.findByGenre("MASCULIN");
			GenreUser genreUsers2 = genreUserRepo.findByGenre("FEMININ");
			if (genreUsers == null || genreUsers2 == null) {
				GenreUser genreUser = new GenreUser();
				genreUser.setGenre("MASCULIN");
				System.out.println("helloGenre");
				GenreUser genreUser1 = new GenreUser();
				genreUser1.setGenre("FEMININ");
				System.out.println("helloFEMININ");
				genreUserRepo.save(genreUser);
				genreUserRepo.save(genreUser1);
			}

			Pays pays = paysRepo.findByPays("MALI");
			Pays pays2 = paysRepo.findByPays("BURKINA FASO");
			Pays pays3 = paysRepo.findByPays("NIGER");
			if (pays == null || pays2 == null || pays3 == null) {
				Pays country = new Pays();
				country.setPays("MALI");
				Pays country1 = new Pays();
				country1.setPays("BURKINA FASO");
				Pays country2 = new Pays();
				country2.setPays("NIGER");
				paysRepo.save(country);
				paysRepo.save(country1);
				paysRepo.save(country2);
			}

			NiveauEtudes niveauEtudes1 = niveauEtudesRepo.findByNiveau("DEBUTANT");
			NiveauEtudes niveauEtudes2 = niveauEtudesRepo.findByNiveau("INTERMEDIAIRE");
			NiveauEtudes niveauEtudes3 = niveauEtudesRepo.findByNiveau("AVANCE");
			if (niveauEtudes1 == null || niveauEtudes2 == null || niveauEtudes3 == null) {
				NiveauEtudes niveauEtude1  = new NiveauEtudes();
				niveauEtude1.setNiveau("DEBUTANT");
				NiveauEtudes niveauEtude2 = new NiveauEtudes();
				niveauEtude2.setNiveau("INTERMEDIAIRE");
				NiveauEtudes niveauEtude3 = new NiveauEtudes();
				niveauEtude3.setNiveau("AVANCE");
				niveauEtudesRepo.save(niveauEtude1);
				niveauEtudesRepo.save(niveauEtude2);
				niveauEtudesRepo.save(niveauEtude3);
			}

			Optional<Utilisateur> utilisateur = utilisateurRepo.findByEmail("houatt0@gmail.com");
			System.out.println("hello1");
			if(utilisateur.isEmpty()){
				System.out.println("hello2");
				Admin admin = new Admin();
				RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
				GenreUser genreUser = genreUserRepo.findByGenre("MASCULIN");
				Pays pay = paysRepo.findByPays("MALI");
				admin.setDateBirthday(new Date());
				admin.setEmail("houatt0@gmail.com");
				admin.setAdresse("Bamako, Senou Medine");
				admin.setNom("Admin Administrateur");
				admin.setPassword(passwordEncoder.encode("12345678"));
				admin.setTelephone("+22372834301");
				admin.setRole(roleUser);
				admin.setGenreUser(genreUser);
				admin.setPays(pay);
				Files files = Files.builder()
						.url("http://localhost:8081/sigidaKanw/resources/image_ressource/13374641.png")
						.type("image/png")
						.build();

				mediaRepository.save(files);
				admin.setFiles(files);

				// Charger l'image depuis les ressources
//				ClassPathResource imgFile = new ClassPathResource("images_source/13374641.png");
//				byte[] imageBytes = Files.readAllBytes(Path.of(imgFile.getURI()));
//
//				MultipartFile multipartFile = new ByteArrayMultipartFile(imageBytes, "13374641.png");

				// Assigner l'image à l'admin
				utilisateurRepo.save(admin);
			}
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner1(StatutEnvoiRepo statutEnvoiRepo) {
		return args -> {
			StatutEnvoi statutEnvois = statutEnvoiRepo.findByStatut("SUCCES");//Or ECHEC
			if (statutEnvois == null) {
				StatutEnvoi statutEnvoi  = new StatutEnvoi();
				statutEnvoi.setStatut("SUCCES");
				statutEnvoiRepo.save(statutEnvoi);
			}
		};
	}
}