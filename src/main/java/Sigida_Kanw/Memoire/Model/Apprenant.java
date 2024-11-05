package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Apprenant extends Utilisateur{

    @OneToOne
    private StatsApprenant stats;

    @ManyToMany
    @JoinTable(
            name = "Apprenant_Language"
    )
    private List<Langue> langues = new ArrayList<>();

    public void addLangue(Langue langue) {
        if (!langues.contains(langue)) {
            langues.add(langue);
        }
    }
}

/*vous pouvez utiliser orphanRemoval pour que les objets qui ne sont plus associés à cette classe soient supprimés automatiquement.*/
