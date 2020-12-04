package com.unibuc.lab8.validators;

import com.unibuc.lab8.dto.ActorDTO;
import com.unibuc.lab8.dto.FilmDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredIfValidatorFilm implements ConstraintValidator<RequireIfFilm, FilmDTO> {


    @Override
    public boolean isValid(FilmDTO filmDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (filmDTO.getDuratafilm() <=0 || filmDTO.getLansare_film() <=0) {
                return false;
        }
        return true;
    }
}
