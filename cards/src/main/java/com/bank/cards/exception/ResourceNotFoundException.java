package com.bank.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s with given %s is not found: %s", entity, fieldName, fieldValue));
    }
}
