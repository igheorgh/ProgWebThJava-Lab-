package com.unibuc.lab8.dto;

import com.unibuc.lab8.validators.RequireIfFilm;
import com.unibuc.lab8.validators.RequiredIf;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequireIfFilm(message = "Film inexistent")
public class FilmDTO {
    private Long id;
    @Pattern(regexp = "[a-zA-Z ]+$")
    private String numefilm;
    private double duratafilm;
    private int lansare_film;
    private String gen_film;
}
