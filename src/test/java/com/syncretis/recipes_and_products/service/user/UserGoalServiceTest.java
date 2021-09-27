package com.syncretis.recipes_and_products.service.user;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.entity.UserGoal;
import com.syncretis.recipes_and_products.entity.UserParameters;
import com.syncretis.recipes_and_products.exception.UserGoalNotFountException;
import com.syncretis.recipes_and_products.exception.UserNotFoundException;
import com.syncretis.recipes_and_products.mapper.UserGoalDtoMapper;
import com.syncretis.recipes_and_products.repository.UserGoalRepository;
import com.syncretis.recipes_and_products.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserGoalServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserGoalRepository userGoalRepository;
    @Mock
    private UserGoalDtoMapper mapper;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserGoalService userGoalService;

    public static final String ID = "id";
    public static final double WEIGHT = 80d;
    public static final UserGoalDto userGoalDto = new UserGoalDto(WEIGHT, 1544);
    public static final UserParameters userParameters = new UserParameters(ID, "woman", 24, 50, 164, 1);
    public static final UserGoal userGoal = new UserGoal(ID, WEIGHT, 1544d);

    @Test
    void shouldReturnUserGoalDtoWhenSettingGoal() {
        //GIVEN
        given(userService.getUserID()).willReturn(ID);
        given(userRepository.findById(ID)).willReturn(Optional.of(userParameters));
        given(mapper.mapUserGoalToUserGoalDto(userGoal)).willReturn(userGoalDto);
        //WHEN
        UserGoalDto actual = userGoalService.setGoal(WEIGHT);
        //THEN
        assertThat(actual).isEqualTo(userGoalDto);
        verify(userService).getUserID();
        verify(userRepository).findById(ID);
        verify(mapper).mapUserGoalToUserGoalDto(userGoal);
    }

    @Test
    void shouldThrowUserNotFoundExceptionWhenSettingGoal() {
        //GIVEN
        given(userService.getUserID()).willReturn(ID);
        given(userRepository.findById(ID)).willReturn(Optional.empty());
        //THEN
        assertThrows(UserNotFoundException.class, () -> userGoalService.setGoal(WEIGHT));
        verify(userService).getUserID();
        verify(userRepository).findById(ID);
    }

    @Test
    void shouldReturnUserGoalDtoWhenGettingGoal() {
        //GIVEN
        given(userService.getUserID()).willReturn(ID);
        given(userGoalRepository.findById(ID)).willReturn(Optional.of(userGoal));
        given(mapper.mapUserGoalToUserGoalDto(userGoal)).willReturn(userGoalDto);
        //WHEN
        UserGoalDto actual = userGoalService.getGoal();
        //THEN
        assertThat(actual).isEqualTo(userGoalDto);
        verify(userService).getUserID();
        verify(userGoalRepository).findById(ID);
        verify(mapper).mapUserGoalToUserGoalDto(userGoal);
    }

    @Test
    void shouldThrowUserNotFoundExceptionWhenGettingGoal() {
        //GIVEN
        given(userService.getUserID()).willReturn(ID);
        given(userGoalRepository.findById(ID)).willReturn(Optional.empty());
        //THEN
        assertThrows(UserGoalNotFountException.class, () -> userGoalService.getGoal());
        verify(userService).getUserID();
        verify(userGoalRepository).findById(ID);
    }
}