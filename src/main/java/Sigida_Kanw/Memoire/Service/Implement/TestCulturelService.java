package Sigida_Kanw.Memoire.Service.Implement;/*package Sigida_Kanw.Memoire.Service.Implement;


import Sigida_Kanw.Memoire.Model.ProgressionCours;
import Sigida_Kanw.Memoire.Model.TestCulturel;
//import Sigida_Kanw.Memoire.Repository.GeneralRepo;
import Sigida_Kanw.Memoire.Repository.TestCulturelRepo;
import Sigida_Kanw.Memoire.Service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TestCulturelService extends CrudService<TestCulturel, Long> {

    public TestCulturelService(JpaRepository< TestCulturel, Long> generalRepo) {
        super(generalRepo);
    }

    public TestCulturel update(Long id, TestCulturel entity) {
        return generalRepo.findById(id)
                .map(
                        p->{
                            p.setContenuCulturel(entity.getContenuCulturel());
                            p.setTitre(entity.getTitre());
                            p.setDescription(entity.getDescription());
                            p.setNbrePoint(entity.getNbrePoint());
                            return generalRepo.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Erreur lors de la mise à jour"));
    }

}
*/