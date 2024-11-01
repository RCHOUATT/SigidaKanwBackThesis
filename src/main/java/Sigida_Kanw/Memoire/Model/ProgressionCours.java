package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class ProgressionCours extends Progression{

    @ManyToOne
    @JsonBackReference("progressionCours")
    private Cours cours;
}
