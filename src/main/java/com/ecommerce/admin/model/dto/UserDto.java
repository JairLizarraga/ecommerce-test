package com.ecommerce.admin.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDto {

    private String email;
    private Integer enabled;
    private String firstName;
    private String lastName;
    private Set<String> roles;

}
