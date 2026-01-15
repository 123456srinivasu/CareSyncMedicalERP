package com.medical.caresync.exceptions;

public class BusinessRuleViolationException extends RuntimeException{

    public BusinessRuleViolationException(String message) {
        super(message);
    }
}
