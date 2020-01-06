package ru.topjava.graduation.util;

import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.util.exception.VoteDenyException;

import static ru.topjava.graduation.util.CurrentTimeUtil.isTimeOver;

public class VoteValidationUtil {

    public static void checkVote(Vote vote) {
        boolean isVoteDeny = (vote != null && isTimeOver());
        if (isVoteDeny) {
            throw new VoteDenyException();
        }
    }
}