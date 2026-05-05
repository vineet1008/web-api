package com.vineet.web_api.users.dao;

import com.vineet.web_api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsActive(int i);

    boolean existsByUsername(String admin);
}