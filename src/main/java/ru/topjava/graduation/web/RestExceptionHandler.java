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
    protected ResponseEntity<RuntimeException> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getNotFoundException());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<RuntimeException> handleConstraintViolationException(JDBCException e) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        RuntimeException exception = getExistsDataException();
        if (e.getErrorCode() == 23506) {
            status = HttpStatus.NOT_FOUND;
            exception = getNotFoundException();
        }
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(VoteDenyException.class)
    protected ResponseEntity<RuntimeException> handleVoteDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getVoteDenyException());
    }

    @ExceptionHandler(EditDenyException.class)
    protected ResponseEntity<RuntimeException> handleEditDenyException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getEditDenyException());
    }

    @ExceptionHandler(OldDateException.class)
    protected ResponseEntity<RuntimeException> handleOldDateException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getOldDateException());
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