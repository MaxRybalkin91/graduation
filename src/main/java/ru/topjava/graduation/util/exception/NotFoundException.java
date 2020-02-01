package ru.topjava.graduation.util.exception;

public class NotFoundException extends RuntimeException {
    private static NotFoundException exception;

    private NotFoundException() {
        super("Requested data not found!");
    }

    public static NotFoundException getNotFoundException() {
        if (exception == null) {
            exception = new NotFoundException();
        }
        return exception;
    }
}