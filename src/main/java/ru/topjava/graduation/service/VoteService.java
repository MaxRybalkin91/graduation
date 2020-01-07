package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.VoteRepository;
import ru.topjava.graduation.util.exception.VoteDenyException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> findForRestaurant(Integer id) {
        return voteRepository.findByRestaurantId(id);
    }

    public Vote vote(Restaurant restaurant, User user) {
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), LocalDate.now());
        if (voteFromRepo != null && LocalTime.now().isAfter(LocalTime.of(11, 0))) {
            throw new VoteDenyException();
        }
        return voteRepository.save(new Vote(restaurant, user));
    }
}