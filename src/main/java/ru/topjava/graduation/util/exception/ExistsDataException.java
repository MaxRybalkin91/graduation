package ru.topjava.graduation.util.exception;

public class ExistsDataException extends RuntimeException {
    public ExistsDataException() {
        super("This data already exists");
    }
}