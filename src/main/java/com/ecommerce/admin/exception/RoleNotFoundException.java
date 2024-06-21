package com.ecommerce.admin.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleNotFoundException extends RuntimeException{

    private String message;

    public RoleNotFoundException(String message){
        this.message = message;
    }
}
