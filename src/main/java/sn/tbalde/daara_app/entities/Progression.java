package sn.tbalde.daara_app.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @NotNull
    @Min(0)
    private Integer nombreVersets;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEvaluation;
    @NotEmpty
    private String apreciation;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTalibe")
    private Talibe talibe;

}
