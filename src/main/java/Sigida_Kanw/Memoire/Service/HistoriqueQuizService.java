package Sigida_Kanw.Memoire.Service;

import Sigida_Kanw.Memoire.Model.HistoriqueQuiz;

import java.util.List;

public interface HistoriqueQuizService {

    HistoriqueQuiz Ajout(HistoriqueQuiz historiqueQuiz);

    List<HistoriqueQuiz> Affiche();

    HistoriqueQuiz MAJ(Long Id, HistoriqueQuiz historiqueQuiz);

    String Supp(Long Id);
}
