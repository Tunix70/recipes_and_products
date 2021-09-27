package com.syncretis.recipes_and_products.service.user;

import com.syncretis.recipes_and_products.dto.rap.UserGoalDto;
import com.syncretis.recipes_and_products.entity.UserGoal;
import com.syncretis.recipes_and_products.entity.UserParameters;
import com.syncretis.recipes_and_products.exception.UserGoalNotFountException;
import com.syncretis.recipes_and_products.exception.UserNotFoundException;
import com.syncretis.recipes_and_products.mapper.UserGoalDtoMapper;
import com.syncretis.recipes_and_products.repository.UserGoalRepository;
import com.syncretis.recipes_and_products.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserGoalService {
    private final UserRepository userRepository;
    private final UserGoalRepository userGoalRepository;
    private final UserGoalDtoMapper mapper;
    private final UserService userService;

    public UserGoalService(UserRepository userRepository, UserGoalRepository userGoalRepository,
                           UserGoalDtoMapper mapper, UserService userService) {
        this.userRepository = userRepository;
        this.userGoalRepository = userGoalRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    public UserGoalDto setGoal(double desiredWeight) {
        String userId = getUserId();
        UserParameters user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND));
        UserGoal userGoal = createUserGoalFromUserParameters(userId, desiredWeight, user);
        UserGoalDto userGoalDto = mapper.mapUserGoalToUserGoalDto(userGoal);
        userGoalRepository.save(userGoal);

        return userGoalDto;
    }

    public UserGoalDto getGoal() {
        String userId = getUserId();
        UserGoal userGoal = userGoalRepository.findById(userId).orElseThrow(() -> new UserGoalNotFountException(HttpStatus.NOT_FOUND));
        return mapper.mapUserGoalToUserGoalDto(userGoal);
    }

    public void deleteGoal() {
        String userId = getUserId();
        if (userGoalRepository.existsById(userId)) {
            userGoalRepository.deleteById(userId);
        }
    }

    private UserGoal createUserGoalFromUserParameters(String userId, double desiredWeight, UserParameters user) {
        String gender = user.getGender();
        double height = user.getHeight();
        int age = user.getAge();
        double kCalPerDay = 0;
        double basicCaloriesCoefficient = (10 * desiredWeight) + (6.25 * height) - (5 * age);

        if (gender.equalsIgnoreCase("man")) {
            kCalPerDay = basicCaloriesCoefficient + 5;
        } else if (gender.equalsIgnoreCase("woman")) {
            kCalPerDay = basicCaloriesCoefficient - 161;
        }

        return new UserGoal(userId, desiredWeight, kCalPerDay);
    }

    private String getUserId() {
        return userService.getUserID();
    }
}