package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer> {
    List<Meal> findAllByRestaurantId(Integer id);

    @Query("select m from Meal m where m.restaurant.id = ?1 and m.date = ?2")
    List<Meal> findAllByRestaurantIdAndDate(Integer restaurantId, LocalDate date);
}