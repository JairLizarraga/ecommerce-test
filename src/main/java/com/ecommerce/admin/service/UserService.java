package com.ecommerce.admin.service;

import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.model.User;
import com.ecommerce.admin.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    Set<Role> getUserRoles(Integer id);

    User saveUser(UserDto userDto);
    User updateUser(Integer userId, UserDto userDto);
    void deleteUser(Integer id);

}
