package ru.topjava.graduation.util.restaurant;

import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.model.dto.VoteTo;

import java.util.List;
import java.util.stream.Collectors;

public class VoteUtil {
    public static List<VoteTo> voteTos(List<Vote> list) {
        return list.stream().map(VoteTo::new).collect(Collectors.toList());
    }
}