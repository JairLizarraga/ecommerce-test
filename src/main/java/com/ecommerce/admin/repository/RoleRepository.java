package com.ecommerce.admin.repository;

import com.ecommerce.admin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
