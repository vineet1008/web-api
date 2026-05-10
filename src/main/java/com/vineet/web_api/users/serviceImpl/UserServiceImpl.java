package com.vineet.web_api.users.serviceImpl;


import com.vineet.web_api.users.dao.RoleRepository;
import com.vineet.web_api.users.dao.UserRepository;
import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.entity.User;
import com.vineet.web_api.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findByIsActive(0);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Id not found " + id));
    }

    public User createUser(User user) {
        Set<Role> roles = user.getRoles().stream()
                .map(role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.getName()))
                )
                .collect(Collectors.toSet());
        user.setRoles(roles);
        user.setModifieddatetime(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setFullName(updatedUser.getFullName());
        user.setEmail(updatedUser.getEmail());
        //user.setUsername(updatedUser.getUsername());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setModifieddatetime(LocalDateTime.now());
        user.setMobile_number(updatedUser.getMobile_number());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setIsActive(1);
            user.setModifieddatetime(LocalDateTime.now());
            userRepository.save(user);
        });
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}