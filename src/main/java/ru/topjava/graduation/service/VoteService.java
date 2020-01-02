package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.VoteRepository;

import java.time.LocalDate;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Transactional
    public Vote vote(Restaurant restaurant, User user) {
        Integer userId = user.getId();
        if (voteRepository.findByUserId(userId) != null) {
            voteRepository.deleteByUserId(userId);
        }
        return voteRepository.save(new Vote(restaurant, user));
    }

    public boolean isUserVoted(User user) {
        return voteRepository.findByUserIdAndDate(user.getId(), LocalDate.now()) != null;
    }
}