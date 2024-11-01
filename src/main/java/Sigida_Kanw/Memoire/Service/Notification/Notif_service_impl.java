package Sigida_Kanw.Memoire.Service.Notification;


import Sigida_Kanw.Memoire.Model.Notification;
import Sigida_Kanw.Memoire.Repository.Notification_repo;
import Sigida_Kanw.Memoire.Service.ContexHolder;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Notif_service_impl implements Notification_service {

    private Notification_repo notificationRepo;
    private JavaMailSender javaMailSender;
    private ContexHolder contexHolder;

    public void SendMail(Notification notification) throws MessagingException{

        String content ="<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
            "<style>" +
                "body {font-family: 'Roboto', sans-serif; background-color: #ffffff; color: white; width: 100vw; height: 100vh; display: flex; justify-content: center; align-content: center; align-items: center;}" +
                ".container { max-width: 600px; margin: auto; padding: 20px; background-color: #1f1f1f; color: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); }" +
                ".header { background-color: #ff7000; padding: 20px; border-radius: 10px 10px 0 0; text-align: center; }" +
                ".header h1 { margin: 0; font-size: 24px; }" +
                ".content { padding: 20px; }" +
                "@page { size: 300px 100px }" +
                ".content p { line-height: 1.6; }" +
                ".footer { text-align: center; color: #888; font-size: 12px; padding: 10px; border-radius: 0 0 10px 10px; background-color: #2c2c2c; }" +
            "</style>" +
        "</head>" +
        "<body>" +
            "<div class='container'>" +
                "<div class='header'>" +
                    "<h1>Bienvenue, "+ contexHolder.utilisateur().getNom()+ " !</h1>" +
                "</div>" +
                "<div class='content'>" +
                    "<p>Merci de vous être inscrit à notre service. Nous sommes ravis de vous avoir avec nous.</p>" +
                "</div>" +
                "<div class='footer'>" +
                    "<p>&copy; 2024 ODK_P4_GP2. Tous droits réservés.</p>"+
                "</div>" +
            "</div>" +
        "</body>" +
        "</html>";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true) ;
        helper.setTo(notification.getDest_email());
        helper.setSubject(notification.getSujet());
        helper.setSentDate(notification.getDateEnvoi());
        helper.setText(content, true);
        System.out.println("hello");


        javaMailSender.send(message);
        notificationRepo.save(notification);
    }

    @Override
    public Notification Ajouter(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public List<Notification> Afficher(Integer id) {
        return notificationRepo.findNotif(id);
    }

    @Override
    public String Delete(Integer id) {
        notificationRepo.deleteById(id);
        return "Votre notification a ete supprimee avec succes";
    }

    public String DeleteAll() {
        notificationRepo.deleteAll();
        return "Les notifications ont etées supprimées avec succès";
    }

    public String DeleteMore(List<Integer> id) {
        id.forEach(e->{
            notificationRepo.deleteById(e);
        });
        return "Les notifications ont etées supprimées avec succès";
    }

}

