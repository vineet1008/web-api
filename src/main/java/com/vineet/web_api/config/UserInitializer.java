package com.vineet.web_api.config;

import com.vineet.web_api.users.dao.UserRepository;
import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.dao.RoleRepository;
import com.vineet.web_api.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        if(!userRepository.existsByUsername("admin")){
            userRepository.save(new User("admin","admin",passwordEncoder.encode("admin123"),"admin@xyz.com"));
        }
    }

    private void createRole() {
        List<String> roleNames = Arrays.asList(
                "ROLE_VIEWER",
                "ROLE_ADMIN"
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


//    @Bean
//    CommandLineRunner initRoles(RoleRepository roleRepository) {
//        return args -> {
//
//
//
//            System.out.println("✅ Roles initialized");
//        };
//    }
}