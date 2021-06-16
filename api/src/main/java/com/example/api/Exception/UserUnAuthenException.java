package com.example.api.Exception;

public class UserUnAuthenException extends RuntimeException{

    public UserUnAuthenException(){
        super("Token Invalid");
    }
    
}
