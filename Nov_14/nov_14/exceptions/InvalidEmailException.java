package com.java.training.nov_14.exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(String err){
        super(err);
    }
}
