package com.pl.priemer_league.error;

import com.pl.priemer_league.error.body.ErrorResponse;
import com.pl.priemer_league.error.exceptions.DublicateIdentifierException;
import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import jdk.jshell.Snippet;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(DublicateIdentifierException.class)
    public ResponseEntity<ErrorResponse> handleDublicateIdentifierException(DublicateIdentifierException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(ex.getMessage())
                .timestamp(ex.getTimestamp())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundPlayer.class)
    public ResponseEntity<ErrorResponse> handleNotFoundPlayer(NotFoundPlayer ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(ex.getDescription())
                .timestamp(ex.getTimestamp())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
