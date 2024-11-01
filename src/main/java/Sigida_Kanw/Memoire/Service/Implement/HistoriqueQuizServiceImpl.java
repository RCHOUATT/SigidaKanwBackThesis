package Sigida_Kanw.Memoire.Service.Implement;

import Sigida_Kanw.Memoire.Model.HistoriqueQuiz;
import Sigida_Kanw.Memoire.Repository.HistoriqueQuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoriqueQuizServiceImpl implements Sigida_Kanw.Memoire.Service.HistoriqueQuizService {

    private HistoriqueQuizRepo historiqueQuizRepo;

    @Override
    public HistoriqueQuiz Ajout(HistoriqueQuiz historiqueQuiz) {
        return historiqueQuizRepo.save(historiqueQuiz);
    }

    @Override
    public List<HistoriqueQuiz> Affiche() {
        return historiqueQuizRepo.findAll();
    }

    @Override
    public HistoriqueQuiz MAJ(Long Id, HistoriqueQuiz historiqueQuiz) {
        return historiqueQuizRepo.findById(Id)
            .map(p->{
                p.setScrore(historiqueQuiz.getScrore());
                p.setPiece(historiqueQuiz.getPiece());
                p.setTest(historiqueQuiz.getTest());
                p.setUtilisateur(historiqueQuiz.getUtilisateur());
                p.setDatePassage(Instant.now());
                return historiqueQuizRepo.save(p);
            }).orElseThrow(()-> new RuntimeException("Erreur lors de la mise à jour"));
    }

    @Override
    public String Supp(Long Id) {
        historiqueQuizRepo.deleteById(Id);
        return "Historique éffacé avec succès";
    }
}
