package com.example.chat.user.repository;

import com.example.chat.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);
    Optional<User> findByUserId(String userId);
    Boolean existsByUserId(String userId);
}
