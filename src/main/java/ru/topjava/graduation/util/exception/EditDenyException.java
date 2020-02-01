package ru.topjava.graduation.util.exception;

public class EditDenyException extends RuntimeException {
    private static EditDenyException exception;

    private EditDenyException() {
        super("You're not able to change history!");
    }

    public static EditDenyException getEditDenyException() {
        if (exception == null) {
            exception = new EditDenyException();
        }
        return exception;
    }
}