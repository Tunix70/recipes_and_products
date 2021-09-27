package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.entity.UserGoal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserGoalDtoMapperTest {
    private final UserGoalDtoMapper mapper = new UserGoalDtoMapper();

    @Test
    public void shouldReturnUserGoalDto() {
        //GIVEN
        UserGoal userGoal = new UserGoal("id", 80d, 1800d);
        UserGoalDto expected = new UserGoalDto(80d, 1800d);
        //WHEN
        UserGoalDto actual = mapper.mapUserGoalToUserGoalDto(userGoal);
        //THEN
        assertThat(actual).isEqualTo(expected);
    }
}