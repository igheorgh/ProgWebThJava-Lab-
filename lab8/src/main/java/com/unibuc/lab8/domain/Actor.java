package com.unibuc.lab8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private Long id;
    @NotNull
    private String nume;
    @NotNull
    private String prenume;
    private int varsta;
    private List<Film> filmeList;

}
