package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.graduation.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {

    List<Vote> findByRestaurantId(Integer id);

    Vote findByUserIdAndDate(Integer userId, LocalDate date);

    Integer countByRestaurantId(Integer restaurantId);
}