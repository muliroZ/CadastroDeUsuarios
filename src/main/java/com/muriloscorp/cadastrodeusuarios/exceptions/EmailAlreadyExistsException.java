package com.muriloscorp.cadastrodeusuarios.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("");
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
