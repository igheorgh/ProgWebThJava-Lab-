package com.java.proiect.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comentariu {
    @NotNull
    private Long id;
    @NotNull
    private Long user_id;
    @NotNull
    private Long produs_id;
    @NotNull
    @Size(max = 150)
    private String comentariu;
}
