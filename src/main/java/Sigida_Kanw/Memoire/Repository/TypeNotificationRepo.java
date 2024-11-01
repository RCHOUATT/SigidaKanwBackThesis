package Sigida_Kanw.Memoire.Repository;

import Sigida_Kanw.Memoire.Model.TypeNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeNotificationRepo extends JpaRepository<TypeNotification, Long> {
    TypeNotification findByType(String type);
}
