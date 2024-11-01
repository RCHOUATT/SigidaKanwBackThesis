package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Apprenant extends Utilisateur{

    @OneToOne(mappedBy = "apprenant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("statApprenant")
    private StatsApprenant stats;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("progressionListUser")
    private List<Progression> progressionList;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("progressionNiveauApprenant")
    private List<ProgressionNiveau> progressionNiveauList;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("progressionLangue")
    private List<ProgressionLangues> progressionLangueList;

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
