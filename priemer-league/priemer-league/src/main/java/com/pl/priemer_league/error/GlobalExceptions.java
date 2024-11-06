package com.pl.priemer_league.error;

import com.pl.priemer_league.error.body.ErrorResponse;
import com.pl.priemer_league.error.exceptions.DublicateIdentifierException;
import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler to manage application-wide exceptions and provide
 * custom error responses.
 * This class handles exceptions globally for the application by using
 * {@link ControllerAdvice}. It intercepts specific exceptions and returns a
 * custom error response to the client.
 *
 * @see DublicateIdentifierException
 * @see NotFoundPlayer
 */
@ControllerAdvice
public class GlobalExceptions {

    /**
     * Handles {@link DublicateIdentifierException} when a duplicate identifier
     * is encountered.
     *
     * @param ex The exception instance containing the error details.
     * @return ResponseEntity containing the error response with HTTP status 409 (CONFLICT).
     */
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

    /**
     * Handles {@link NotFoundPlayer} exception when a player is not found.
     *
     * @param ex The exception instance containing the error details.
     * @return ResponseEntity containing the error response with HTTP status 404 (NOT_FOUND).
     */
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
