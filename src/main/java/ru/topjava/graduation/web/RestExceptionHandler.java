package ru.topjava.graduation.web;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.topjava.graduation.util.exception.ExistsDataException;
import ru.topjava.graduation.util.exception.NotFoundException;
import ru.topjava.graduation.util.exception.VoteDenyException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<String> handleConstraintViolationException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExistsDataException().getMessage());
    }

    @ExceptionHandler(VoteDenyException.class)
    protected ResponseEntity<String> handleVoteDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new VoteDenyException().getMessage());
    }
}