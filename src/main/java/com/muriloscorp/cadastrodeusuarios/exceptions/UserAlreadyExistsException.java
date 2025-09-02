package com.muriloscorp.cadastrodeusuarios.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Já existe um usuário com esse email!");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
