package ru.topjava.graduation.util.exception;

public class VoteDenyException extends RuntimeException {
    private static VoteDenyException exception;

    private VoteDenyException() {
        super("Your time for voting is over today! Come back tomorrow!");
    }

    public static VoteDenyException getVoteDenyException() {
        if (exception == null) {
            exception = new VoteDenyException();
        }
        return exception;
    }
}