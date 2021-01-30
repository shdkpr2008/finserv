package com.finserv.advice;

import com.finserv.exception.NotFoundException;
import com.finserv.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    ResponseEntity<String> userNotFoundHandler(UserNotFoundException ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String body = "{ \"message\" : \"" + ex.getMessage() + "\" }";
        return new ResponseEntity<>(body, responseHeaders, HttpStatus.NOT_FOUND);
    }

}
