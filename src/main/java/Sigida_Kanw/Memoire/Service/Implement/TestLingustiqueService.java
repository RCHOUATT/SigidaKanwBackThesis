package Sigida_Kanw.Memoire.Service.Implement;/*package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.TestCulturel;
import Sigida_Kanw.Memoire.Model.TestLingustique;
//import Sigida_Kanw.Memoire.Repository.GeneralRepo;
import Sigida_Kanw.Memoire.Repository.TestLingustiqueRepo;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TestLingustiqueService extends CrudService<TestLingustique, Long> {

    public TestLingustiqueService(JpaRepository< TestLingustique, Long> generalRepo) {
        super(generalRepo);
    }

    public TestLingustique update(Long id, TestLingustique entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setLesson(entity.getLesson());
                            p.setTitre(entity.getTitre());
                            p.setDescription(entity.getDescription());
                            p.setNbrePoint(entity.getNbrePoint());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }

}
*/