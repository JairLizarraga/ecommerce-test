package com.ecommerce.admin;

import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.model.dto.UserDto;
import com.ecommerce.admin.repository.RoleRepository;
import com.ecommerce.admin.repository.UserRepository;
import com.ecommerce.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = Role
                .builder()
                .name("ADMIN")
                .description("Can manage everything")
                .build();
        roleRepository.save(adminRole);

        Role userRole = Role
                .builder()
                .name("USER")
                .description("Typical visitor")
                .build();
        roleRepository.save(userRole);

        UserDto user1 = UserDto.builder()
                .firstName("Alice")
                .lastName("Smith")
                .email("alice.smith@example.com")
                .roles(Set.of("ADMIN", "USER"))
                .enabled(1)
                .build();

        UserDto user2 = UserDto.builder()
                .firstName("Bob")
                .lastName("Johnson")
                .email("bob.johnson@example.com")
                .roles(Set.of("USER"))
                .enabled(1)
                .build();

        UserDto user3 = UserDto.builder()
                .firstName("Emma")
                .lastName("Brown")
                .email("email")
                .roles(Set.of("ADMIN"))
                .enabled(1)
                .build();

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
    }
}
