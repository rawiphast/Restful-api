package com.example.api.Exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id){
        super("Could not find user " + id);
    }
    
}
