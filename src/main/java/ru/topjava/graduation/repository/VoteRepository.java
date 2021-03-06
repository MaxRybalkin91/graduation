package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.dto.VoteToDate;
import ru.topjava.graduation.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {

    Vote findByUserIdAndDate(Integer userId, LocalDate date);

    Integer countByRestaurantId(Integer restaurantId);

    @Override
    @Transactional
    Vote save(Vote item);

    @Query("select new ru.topjava.graduation.dto.VoteToDate(v.date, count(v.id))" +
            " from Vote v where v.restaurant.id = ?1 and v.restaurant.user.id = ?2" +
            " group by v.date")
    List<VoteToDate> groupCountByDate(Integer restaurantId, Integer userId);
}