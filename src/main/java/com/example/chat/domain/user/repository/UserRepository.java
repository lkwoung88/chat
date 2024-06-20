package com.example.chat.domain.user.repository;

import com.example.chat.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);
    User findByUserId(String userId);
    Boolean existsByUserId(String userId);
}