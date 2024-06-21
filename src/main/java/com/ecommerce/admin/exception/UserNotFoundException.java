package com.ecommerce.admin.exception;

import com.ecommerce.admin.model.User;
import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;

@Setter
@Getter
public class UserNotFoundException extends RuntimeException{

    private String message;

    public UserNotFoundException(String message){
        this.message = message;
    }
}
