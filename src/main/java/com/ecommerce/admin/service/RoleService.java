package com.ecommerce.admin.service;

import com.ecommerce.admin.model.Role;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();
    public Role getRole(int id);
    public Role getRoleByName(String name);

}
