package com.vineet.web_api.config;

import com.vineet.web_api.users.dao.UserRepository;
import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.dao.RoleRepository;
import com.vineet.web_api.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class UserInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        createRole();
        createUser();
    }

    private void createUser() {
        if(!userRepository.existsByUsername("admin")){
            userRepository.save(new User("admin","admin","admin123","admin@xyz.com"));
        }
    }

    private void createRole() {
        if (!roleRepository.findByName("ROLE_USER").isPresent()) {
            roleRepository.save(new Role("ROLE_USER"));
        }

        if (!roleRepository.findByName("ROLE_ADMIN").isPresent()) {
            roleRepository.save(new Role("ROLE_ADMIN"));
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