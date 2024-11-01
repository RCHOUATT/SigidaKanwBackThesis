package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.api.services.drive.model.App;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

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
    @JsonBackReference("progressionNiveauApprenant")
    private Apprenant apprenant;
}
