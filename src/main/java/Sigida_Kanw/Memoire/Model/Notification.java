package Sigida_Kanw.Memoire.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //@JsonBackReference("notifR")
    private Utilisateur utilisateur;


    private String sujet;
    private Date dateEnvoi = new Date();

    @ManyToOne
    @JoinColumn(name = "statutEnvoi_id")
    //@JsonBackReference("notifR")
    private StatutEnvoi status;

    @ManyToOne
    private TypeNotification typeNotification;

    private String message;
    private String dest_email;

    @ManyToMany
    List<Utilisateur> destinateurs;
}
