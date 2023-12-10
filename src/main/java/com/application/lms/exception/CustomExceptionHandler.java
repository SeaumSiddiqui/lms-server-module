package com.application.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class, CourseNotFoundException.class, LectureNotFoundException.class})
    public Map<String, String> handleNotFoundException(LectureNotFoundException ex) {
        return errorMapping(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NameAlreadyTakenException.class)
    public Map<String, String> handleBadRequestException(NameAlreadyTakenException ex) {
        return errorMapping(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


    private Map<String, String> errorMapping(HttpStatus status, String message) {
        Map<String, String> error = new HashMap<>();
        error.put("error", message);
        error.put("status", String.valueOf(status.value()));
        return error;
    }
}
