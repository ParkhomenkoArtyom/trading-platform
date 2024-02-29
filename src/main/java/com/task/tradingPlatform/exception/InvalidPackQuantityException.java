package com.task.tradingPlatform.exception;

public class InvalidPackQuantityException extends RuntimeException{
    public InvalidPackQuantityException(String message){
        super(message);
    }
}
