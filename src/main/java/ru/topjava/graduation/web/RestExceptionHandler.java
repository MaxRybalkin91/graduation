package ru.topjava.graduation.web;

import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.topjava.graduation.util.exception.*;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<String> handleConstraintViolationException(JDBCException e) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String message = new ExistsDataException().getMessage();
        if (e.getErrorCode() == 23506) {
            status = HttpStatus.NOT_FOUND;
            message = new NotFoundException().getMessage();
        }
        return ResponseEntity.status(status).body(message);
    }

    @ExceptionHandler(VoteDenyException.class)
    protected ResponseEntity<String> handleVoteDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new VoteDenyException().getMessage());
    }

    @ExceptionHandler(EditDenyException.class)
    protected ResponseEntity<String> handleEditDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new EditDenyException().getMessage());
    }

    @ExceptionHandler(InvalidSaveException.class)
    protected ResponseEntity<String> handleInvalidSaveException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new InvalidSaveException().getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getBindingResult()
                        .getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage)
                        .collect(Collectors.toList()));
    }
}