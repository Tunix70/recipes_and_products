package com.syncretis.recipes_and_products.repository;

import com.syncretis.recipes_and_products.entity.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserParameters, String> {
    Optional<UserParameters> findById(String s);
}