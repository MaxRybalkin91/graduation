package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.VoteRepository;
import ru.topjava.graduation.util.exception.VoteDenyException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote vote(User user, String dateAndTime) {
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime);
        LocalDate date = dateTime.toLocalDate();
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), date);
        if (voteFromRepo != null && dateTime.getHour() >= 11) {
            throw new VoteDenyException();
        }
        return voteRepository.save(new Vote(date, user));
    }

    public Integer votesCount(Integer restaurantId) {
        return voteRepository.countByRestaurantId(restaurantId);
    }
}