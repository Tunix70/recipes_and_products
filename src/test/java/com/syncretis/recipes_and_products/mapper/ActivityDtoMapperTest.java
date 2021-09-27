package com.syncretis.recipes_and_products.mapper;

import com.syncretis.recipes_and_products.domain.Activity;
import com.syncretis.recipes_and_products.dto.rap.ActivityDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ActivityDtoMapperTest {
    private final ActivityDtoMapper mapper = new ActivityDtoMapper();

    @Test
    void shouldCorrectMapActivityDomainToDto() {
        //GIVEN
        Activity activity = new Activity("running", 11.43, 1);
        ActivityDto expected = new ActivityDto("running", 11.43);
        //WHEN
        ActivityDto actual = mapper.map(activity);
        //GIVEN
        assertThat(actual).isEqualTo(expected);
    }
}