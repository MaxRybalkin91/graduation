package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.repository.VoteRepository;
import ru.topjava.graduation.util.exception.NotFoundException;
import ru.topjava.graduation.util.exception.VoteDenyException;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Integer votesCount(Integer restaurantId) {
        return voteRepository.countByRestaurantId(restaurantId);
    }

    public Vote create(User user, String time, Integer restaurantId) {
        LocalTime userTime = LocalTime.parse(time);
        return checkAndSave(userTime, user, restaurantId);
    }

    public Vote create(User user, Integer restaurantId) {
        return checkAndSave(LocalTime.now(), user, restaurantId);
    }

    private Vote checkAndSave(LocalTime time, User user, Integer restaurantId) {
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), LocalDate.now());
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
        if (voteFromRepo != null && time.getHour() >= 11) {
            throw new VoteDenyException();
        }
        return voteRepository.save(new Vote(user, restaurant));
    }
}