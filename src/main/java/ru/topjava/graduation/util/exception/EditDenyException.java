package ru.topjava.graduation.util.exception;

public class EditDenyException extends RuntimeException {
    public EditDenyException() {
        super("You're not able to change history!");
    }
}