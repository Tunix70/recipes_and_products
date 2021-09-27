package com.syncretis.recipes_and_products.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UserGoalDtoValidator implements ConstraintValidator<DesiredWeightConstraint, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value >= 4 && value <= 300;
    }
}