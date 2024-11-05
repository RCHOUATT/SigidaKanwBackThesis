package Sigida_Kanw.Memoire.Repository;


import Sigida_Kanw.Memoire.Model.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepo extends JpaRepository<RoleUser, Long> {
    RoleUser findByRole(String role);
}