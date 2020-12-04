package com.unibuc.lab8.dto;

import com.unibuc.lab8.validators.RequiredIf;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredIf(message = "Actor inexistent")
public class ActorDTO {
    private Long actor_cnp;
    @Size(min = 3, max = 50)
    private String numeActor;
    @Size(min = 3, max = 50)
    private String prenumeActor;
    @Min(10)
    private int varstaActor;
    private List<FilmDTO> ListaFilme;
}
