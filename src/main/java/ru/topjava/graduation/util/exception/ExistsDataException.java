package ru.topjava.graduation.util.exception;

public class ExistsDataException extends RuntimeException {
    private static ExistsDataException exception;

    private ExistsDataException() {
        super("The same note already exists!");
    }

    public static ExistsDataException getExistsDataException() {
        if (exception == null) {
            exception = new ExistsDataException();
        }
        return exception;
    }
}