package com.bank.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardAlreadyExistException extends RuntimeException {
    public CardAlreadyExistException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s with %s already exists: %s", entity, fieldName, fieldValue));
    }
}
