package com.ecommerce.admin.controller;

import com.ecommerce.admin.model.Role;
import com.ecommerce.admin.service.RoleService;
import com.ecommerce.admin.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
}
