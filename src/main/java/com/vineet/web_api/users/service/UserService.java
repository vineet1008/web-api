package com.vineet.web_api.users.service;

import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<Role> getAllRoles();
}