package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.dto.VoteToDate;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.topjava.graduation.util.exception.VoteDenyException.getVoteDenyException;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Cacheable("votes")
    public Integer getVotesCount(Integer restaurantId) {
        return voteRepository.countByRestaurantId(restaurantId);
    }

    @Value("${time.vote.deny}")
    private Integer denyHour;

    @CacheEvict(value = "votes", allEntries = true)
    public Vote create(User user, Integer restaurantId, LocalTime time) {
        return checkAndSave(time, user, restaurantId);
    }

    @CacheEvict(value = "votes", allEntries = true)
    public Vote create(User user, Integer restaurantId) {
        return checkAndSave(LocalTime.now(), user, restaurantId);
    }

    private Vote checkAndSave(LocalTime time, User user, Integer restaurantId) {
        Vote voteFromRepo = voteRepository.findByUserIdAndDate(user.getId(), LocalDate.now());
        if (voteFromRepo != null) {
            if (time.getHour() >= denyHour) {
                throw getVoteDenyException();
            }
            voteFromRepo.setRestaurant(restaurantRepository.getOne(restaurantId));
            return voteRepository.save(voteFromRepo);
        }
        return voteRepository.save(new Vote(user, restaurantRepository.getOne(restaurantId)));
    }

    public List<VoteToDate> getVotesStatistic(Integer restaurantId, Integer userId) {
        return voteRepository.groupCountByDate(restaurantId, userId);
    }
}