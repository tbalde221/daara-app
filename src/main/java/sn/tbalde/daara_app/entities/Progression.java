package sn.tbalde.daara_app.entities;

import java.util.Date;

import groovy.transform.builder.Builder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Progression {
    @Id
    private String idProgression;
    @NotEmpty
    private String sourate;
    @NotEmpty
    @Size(min = 0)
    private Integer nombreVersets;
    @NotEmpty
    private Date dateEvaluation;
    @NotEmpty
    private String apreciation;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTalibe")
    private Talibe talibe;

}
