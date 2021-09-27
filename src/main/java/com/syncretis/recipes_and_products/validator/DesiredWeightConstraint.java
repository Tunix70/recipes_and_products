package com.syncretis.recipes_and_products.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;

@Constraint(validatedBy = UserGoalDtoValidator.class)
@Target({PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DesiredWeightConstraint {
    String message() default "Weight should be between 4 and 300.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
