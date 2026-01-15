package com.medical.caresync.exceptions;

import com.medical.caresync.dto.ValidationError;

import java.util.List;

public class CampRunValidationException extends RuntimeException {

    private final List<ValidationError> errors;

    public CampRunValidationException(List<ValidationError> errors) {
        super("CampRun validation failed");
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
