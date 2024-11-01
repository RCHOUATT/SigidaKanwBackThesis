package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.api.services.drive.model.App;
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
public class ProgressionLangues extends Progression{

    @ManyToOne
    private Langue langue;

    @ManyToOne
    @JsonBackReference("progressionLangue")
    private Apprenant apprenant;
}
