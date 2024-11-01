package Sigida_Kanw.Memoire.Service;

//import Sigida_Kanw.Memoire.Repository.GeneralRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public abstract class CrudService<T, IDtype> {

    public final JpaRepository<T, IDtype> generalRepo;

    public T Ajouter(T entity){
        return generalRepo.save(entity);
    };

    public List<T> displayAll() {
        return generalRepo.findAll();
    };
    public T display(IDtype id){
        return generalRepo.findById(id).get();
    };
    public String delete(IDtype id){
        generalRepo.deleteById(id);
        return "Suppression reussite avec succès";
    };

    public String deleteAll(){
        generalRepo.deleteAll();
        return "Suppression reussite avec succès";
    };

    public String deleteMore(List<IDtype> id){
        id.forEach(e->{
            generalRepo.deleteById(e);
        });
        return "Suppression reussite avec succès";
    };
}
