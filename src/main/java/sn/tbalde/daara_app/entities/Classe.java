package sn.tbalde.daara_app.entities;

import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.tbalde.daara_app.enums.Niveau;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Classe {
    @Id
    private String codeClasse;
    @NotEmpty
    @Size(max = 50)
    private String libelle;
    private Niveau niveau;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idMaitre")
    private Maitre maitre;
}
