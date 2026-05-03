package com.vineet.web_api.config;

import com.vineet.web_api.users.entity.Role;
import com.vineet.web_api.users.dao.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleLoader {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {

            if (!roleRepository.findByName("ROLE_USER").isPresent()) {
                roleRepository.save(new Role("ROLE_USER"));
            }

            if (!roleRepository.findByName("ROLE_ADMIN").isPresent()) {
                roleRepository.save(new Role("ROLE_ADMIN"));
            }

            System.out.println("✅ Roles initialized");
        };
    }
}