package ru.topjava.graduation.util.exception;

public class VoteDenyException extends RuntimeException {
    public VoteDenyException() {
        super("Your time for vote again is over!");
    }
}