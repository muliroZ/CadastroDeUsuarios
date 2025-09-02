package com.muriloscorp.cadastrodeusuarios.controller;

import com.muriloscorp.cadastrodeusuarios.exceptions.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    private ResponseEntity<String> userAlreadyExistsError(EmailAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário com esse email!");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentError(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome e email são obrigatórios!");
    }
}
