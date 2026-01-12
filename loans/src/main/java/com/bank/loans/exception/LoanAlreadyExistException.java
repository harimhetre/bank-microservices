package com.bank.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanAlreadyExistException extends RuntimeException {
    public LoanAlreadyExistException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s already exist for %s: %s", entity, fieldName, fieldValue));
    }
}
