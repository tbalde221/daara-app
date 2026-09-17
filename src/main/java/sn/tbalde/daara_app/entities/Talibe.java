package sn.tbalde.daara_app.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Talibe {
    @Id
    private String idTalibe;
    @NotEmpty
    @Size(max = 50)
    private String prenom;
    @NotEmpty
    @Size(max = 50)
    private String nom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @NotEmpty
    @Size(max = 100)
    private String nomTuteur;
    @NotEmpty
    @Size(max = 20, min = 9)
    private String telephoneTuteur;
    @ManyToOne(optional = false)
    @JoinColumn(name = "codeClasse")
    private Classe classe;
}
