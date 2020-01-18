package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.graduation.model.Vote;

import java.time.LocalDate;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {

    Vote findByUserIdAndDate(Integer userId, LocalDate date);

    Integer countByRestaurantId(Integer restaurantId);
}