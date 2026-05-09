package com.vineet.web_api.config;

import com.vineet.web_api.constant.ApplicationConstants;
import com.vineet.web_api.users.dao.UserRepository;
import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.dao.RoleRepository;
import com.vineet.web_api.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class UserInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        createRole();
        createUser();
    }

    private void createUser() {
        Role adminRole = roleRepository.findByName(ApplicationConstants.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Set<Role> roles=new HashSet<>();
        roles.add(adminRole);
        if(!userRepository.existsByUsername(ApplicationConstants.ADMIN)){
            userRepository.save(new User(ApplicationConstants.ADMIN,ApplicationConstants.ADMIN,passwordEncoder.encode(ApplicationConstants.ADMIN_PASSWORD),"admin@xyz.com",roles));
        }
    }

    private void createRole() {
        List<String> roleNames = Arrays.asList(
                ApplicationConstants.ROLE_VIEWER,
                ApplicationConstants.ROLE_ADMIN
        );
        List<Role> rolesToSave = roleNames.stream()
                .filter(roleName -> !roleRepository.findByName(roleName).isPresent())
                .map(Role::new)
                .collect(Collectors.toList());

        if (!rolesToSave.isEmpty()) {
            roleRepository.saveAll(rolesToSave);
        }
        System.out.println("✅ Roles initialized");
    }
}