package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProgressionNiveau extends Progression{

    @ManyToOne
    private NiveauEtudes niveauEtudes;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Apprenant apprenant;
}
