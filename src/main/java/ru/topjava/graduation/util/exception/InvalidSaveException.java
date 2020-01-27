package ru.topjava.graduation.util.exception;

public class InvalidSaveException extends RuntimeException {
    public InvalidSaveException() {
        super("You're trying to save that meal to another restaurant!");
    }
}