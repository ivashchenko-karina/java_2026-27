package com.example.spaceportal.repository;

import com.example.spaceportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Метод для пошуку користувача за логіном
    Optional<User> findByUsername(String username);
}
