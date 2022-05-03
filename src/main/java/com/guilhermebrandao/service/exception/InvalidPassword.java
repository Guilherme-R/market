package com.guilhermebrandao.service.exception;

public class InvalidPassword extends RuntimeException{

    public InvalidPassword(String msg){
        super(msg);
    }
}
