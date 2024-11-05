package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Notification_repo extends JpaRepository<Notification, Integer> {
    @Query("SELECT n FROM Notification n WHERE n.utilisateur.id = :id")
    List<Notification> findNotif(@Param("id") Integer id);
}
