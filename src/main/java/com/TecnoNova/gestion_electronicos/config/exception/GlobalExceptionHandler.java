package com.TecnoNova.gestion_electronicos.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorMensaje.class)
    public ResponseEntity<ErrorDto> handleError(ErrorMensaje errorMensaje) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(errorMensaje.getMessage(), LocalTime.now()));
    }
}
