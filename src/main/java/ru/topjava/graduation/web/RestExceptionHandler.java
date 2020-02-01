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
import ru.topjava.graduation.util.exception.EditDenyException;
import ru.topjava.graduation.util.exception.NotFoundException;
import ru.topjava.graduation.util.exception.OldDateException;
import ru.topjava.graduation.util.exception.VoteDenyException;

import java.util.List;
import java.util.stream.Collectors;

import static ru.topjava.graduation.util.exception.EditDenyException.getEditDenyException;
import static ru.topjava.graduation.util.exception.ExistsDataException.getExistsDataException;
import static ru.topjava.graduation.util.exception.NotFoundException.getNotFoundException;
import static ru.topjava.graduation.util.exception.OldDateException.getOldDateException;
import static ru.topjava.graduation.util.exception.VoteDenyException.getVoteDenyException;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getNotFoundException().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<String> handleConstraintViolationException(JDBCException e) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String message = getExistsDataException().getMessage();
        if (e.getErrorCode() == 23506) {
            status = HttpStatus.NOT_FOUND;
            message = getNotFoundException().getMessage();
        }
        return ResponseEntity.status(status).body(message);
    }

    @ExceptionHandler(VoteDenyException.class)
    protected ResponseEntity<String> handleVoteDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getVoteDenyException().getMessage());
    }

    @ExceptionHandler(EditDenyException.class)
    protected ResponseEntity<String> handleEditDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getEditDenyException().getMessage());
    }

    @ExceptionHandler(OldDateException.class)
    protected ResponseEntity<String> handleOldDateException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getOldDateException().getMessage());
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