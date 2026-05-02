package com.vineet.web_api.users.dao;

import com.vineet.web_api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}