package com.ecommerce.admin.service.impl;


import com.ecommerce.admin.exception.UserNotFoundException;
import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.model.User;
import com.ecommerce.admin.model.dto.UserDto;
import com.ecommerce.admin.repository.RoleRepository;
import com.ecommerce.admin.repository.UserRepository;
import com.ecommerce.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public Set<Role> getUserRoles(Integer id){
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id))
                .getRoles();

    }

    public User saveUser(UserDto userDto){
        Set<Role> roles = new HashSet<>();
        for(String roleName: userDto.getRoles()){
            Role role = roleRepository.findByName(roleName);
            roles.add(role);
        }

        User user = User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .enabled(userDto.getEnabled())
                .roles(roles)
                .password(passwordEncoder.encode("pass"))
                .build();

        return userRepository.save(user);
    }


    public User updateUser(Integer userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getEnabled() != null) {
            user.setEnabled(userDto.getEnabled());
        }
        if (userDto.getFirstName() != null) {
            user.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null) {
            user.setLastName(userDto.getLastName());
        }

        if (userDto.getRoles() != null && !userDto.getRoles().isEmpty()) {
            Set<Role> roles = new HashSet<>();
            for (String roleName : userDto.getRoles()) {
                Role role = roleRepository.findByName(roleName);
                if (role != null) {
                    roles.add(role);
                }
            }
            user.setRoles(roles);
        }

        return user;
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }

}
