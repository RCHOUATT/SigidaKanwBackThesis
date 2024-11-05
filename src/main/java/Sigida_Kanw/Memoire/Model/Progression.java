package Sigida_Kanw.Memoire.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Progression {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Double avancement;
    private Instant dataAcces;
    private Instant dateDernActivite;

    @ManyToOne
    private Apprenant apprenant;
}
