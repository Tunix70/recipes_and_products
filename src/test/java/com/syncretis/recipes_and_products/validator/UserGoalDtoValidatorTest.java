package com.syncretis.recipes_and_products.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserGoalDtoValidatorTest {
    private final UserGoalDtoValidator validator = new UserGoalDtoValidator();

    @Test
    public void shouldValidateWeight() {
        //GIVEN
        double weight = 150d;
        //WHEN
        boolean actual = validator.isValid(weight, null);
        //THEN
        assertThat(actual).isTrue();
    }

    @Test
    public void shouldThrowInvalidDesiredWeightException() {
        //GIVEN
        double weight = -10d;
        //WHEN
        boolean actual = validator.isValid(weight, null);
        //THEN
        assertThat(actual).isFalse();
    }
}