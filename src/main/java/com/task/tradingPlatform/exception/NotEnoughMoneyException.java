package com.task.tradingPlatform.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message){
        super(message);
    }
}
