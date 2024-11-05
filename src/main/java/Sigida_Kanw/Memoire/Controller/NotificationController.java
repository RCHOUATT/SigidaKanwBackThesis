package Sigida_Kanw.Memoire.Controller;

import Sigida_Kanw.Memoire.Model.Notification;
import Sigida_Kanw.Memoire.Service.Notification.Notif_service_impl;
import com.google.zxing.WriterException;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="*")
@Controller
@RestController
@RequestMapping("notification")
@AllArgsConstructor
public class NotificationController {

    private Notif_service_impl notificationService;

    @PostMapping("/send")
    public void SendMail(@RequestBody Notification notification) throws MessagingException, IOException, DocumentException, WriterException {
            notificationService.SendMail(notification);
    }

    @PostMapping("/add")
    public Notification Ajouter(Notification notification) {
        return notificationService.Ajouter(notification);
    }

    @GetMapping("/Afficher")
    public List<Notification> Afficher(Integer id) {
        return notificationService.Afficher(id);
    }

    @DeleteMapping("/Delete")
    public String Delete(Integer id) {
        return notificationService.Delete(id);
    }

    @DeleteMapping("/DeleteMore")
    public String Deleteplus(List<Integer> id) {
        return notificationService.DeleteMore(id);
    }

    @DeleteMapping("/DeleteAll")
    public String DeleteAll() {
        return notificationService.DeleteAll();
    }
}
