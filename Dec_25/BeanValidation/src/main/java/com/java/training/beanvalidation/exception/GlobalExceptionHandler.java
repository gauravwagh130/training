package com.java.training.beanvalidation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Helper to build ErrorMessage
    private ResponseEntity<ErrorMessage> buildError(HttpStatus status, String message, String description) {
        ErrorMessage err = new ErrorMessage(status.value(), LocalDateTime.now(), message, description);
        return new ResponseEntity<>(err, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        logger.warn("IllegalArgumentException: {}",ex.getMessage());
        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
    }

    // Handle validation errors from @Valid

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
            logger.warn("Validation failed: {}",errors);
        ErrorMessage err = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
                "Validation failed", errors);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAll(Exception ex, WebRequest request) {
        logger.error("Unexpected error:", ex);
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", request.getDescription(false));
    }
}
