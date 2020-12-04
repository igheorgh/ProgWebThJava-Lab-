package com.unibuc.lab8.validators;

import com.unibuc.lab8.dto.ActorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredIfValidator implements ConstraintValidator<RequiredIf, ActorDTO> {

    @Override
    public boolean isValid(ActorDTO value, ConstraintValidatorContext context) {
        if (value.getActor_cnp() != null) {
            String s= String.valueOf(value.getActor_cnp());
            if(s.length()!=13)
                return false;
        }
        return true;
    }
}
