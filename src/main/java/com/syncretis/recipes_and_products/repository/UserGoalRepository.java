package com.syncretis.recipes_and_products.repository;

import com.syncretis.recipes_and_products.entity.UserGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoal, String> {
    Optional<UserGoal> findById(String s);

    void deleteById(String s);

    boolean existsById(String s);
}