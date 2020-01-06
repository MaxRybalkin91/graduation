package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.topjava.graduation.util.VoteValidationUtil.checkVote;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> findForRestaurant(Integer id) {
        return voteRepository.findByRestaurantId(id);
    }

    public Vote vote(Restaurant restaurant, User user) {
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), LocalDate.now());
        checkVote(voteFromRepo);
        return voteRepository.save(new Vote(restaurant, user));
    }

    public void deleteById(Integer id) {
        voteRepository.deleteById(id);
    }
}