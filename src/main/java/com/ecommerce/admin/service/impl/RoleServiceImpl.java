package com.ecommerce.admin.service.impl;

import com.ecommerce.admin.exception.RoleNotFoundException;
import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.repository.RoleRepository;
import com.ecommerce.admin.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role getRole(int id){
        return roleRepository
                .findById(id)
                .orElseThrow(() ->  new RoleNotFoundException("Role not found with ID: " + id));
    }

    public Role getRoleByName(String name){
        return roleRepository.findByName(name);
    }
}
