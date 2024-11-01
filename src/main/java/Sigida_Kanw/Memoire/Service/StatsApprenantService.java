package Sigida_Kanw.Memoire.Service;

import Sigida_Kanw.Memoire.Model.StatsApprenant;

import java.util.List;


public interface StatsApprenantService {

    List<StatsApprenant> Affiche();

    StatsApprenant MAJ(Long Id, StatsApprenant statsApprenant);

    String Supp(Long Id);
}
