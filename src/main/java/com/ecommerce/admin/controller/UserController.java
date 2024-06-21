package com.ecommerce.admin.controller;

import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.model.User;
import com.ecommerce.admin.model.dto.UserDto;
import com.ecommerce.admin.repository.RoleRepository;
import com.ecommerce.admin.service.UserService;
import com.ecommerce.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository){
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }


    @GetMapping("/{id}/roles")
    public Set<Role> getUserRoles(@PathVariable Integer id){
        return userService.getUserRoles(id);
    }

    // Create user with roles
    @PostMapping("/")
    public User createUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }

    // Update user info
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    // delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
