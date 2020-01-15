package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.VoteRepository;
import ru.topjava.graduation.util.exception.VoteDenyException;

import java.time.LocalDateTime;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote vote(Restaurant restaurant, User user, String dateAndTime) {
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime);
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), dateTime.toLocalDate());
        if (voteFromRepo != null && dateTime.getHour() >= 11) {
            throw new VoteDenyException();
        }
        return voteRepository.save(new Vote(restaurant, user));
    }

    public Integer votesCount(Integer restaurantId) {
        return voteRepository.countByRestaurantId(restaurantId);
    }
}