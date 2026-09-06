package sn.tbalde.daara_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Maitre {
    @Id
    @NotEmpty
    private String idMaitre;
    @NotEmpty
    @Size(max = 50)
    private String nom;
    @NotEmpty
    @Size(max = 50)
    private String prenom;
    @NotEmpty
    @Size(max = 20, min = 9)
    private String telephone;
}
