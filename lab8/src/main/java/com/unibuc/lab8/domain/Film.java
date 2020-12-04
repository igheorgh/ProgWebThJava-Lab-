package com.unibuc.lab8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @NotNull
    private Long id;
    private String nume_film;
    private double durata;
    private int lansare;
    private String gen;
}
