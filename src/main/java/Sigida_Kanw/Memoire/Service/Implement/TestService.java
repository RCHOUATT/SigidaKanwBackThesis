package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.Test;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService extends CrudService<Test, Long> {

    public TestService(JpaRepository<Test, Long> generalRepo) {
        super(generalRepo);
    }

    public Test update(Long id, Test entity) {
        return generalRepo.findById(id)
                .map(
                    p->{
                        if (entity.getTitre() != null){
                            p.setTitre(entity.getTitre());
                        }
                        if (entity.getDescription() != null){
                            p.setDescription(entity.getDescription());
                        }
                        if (entity.getNbrePoint() != null){
                            p.setNbrePoint(entity.getNbrePoint());
                        }
                        /*if (entity.getTypeTest() != null){
                            p.setTypeTest(entity.getTypeTest());
                        }*/
                        if (entity.getChapitre() != null){
                            p.setChapitre(entity.getChapitre());
                        }
                        return generalRepo.save(p);
                    }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }
}
