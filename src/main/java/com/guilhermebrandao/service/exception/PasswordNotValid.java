package com.guilhermebrandao.service.exception;

public class PasswordNotValid extends RuntimeException{

    public PasswordNotValid(String msg){
        super(msg);
    }
}
