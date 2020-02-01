package ru.topjava.graduation.util.exception;

public class OldDateException extends RuntimeException {
    private static OldDateException exception;

    private OldDateException() {
        super("You're trying to add that meal to history!");
    }

    public static OldDateException getOldDateException() {
        if (exception == null) {
            exception = new OldDateException();
        }
        return exception;
    }
}