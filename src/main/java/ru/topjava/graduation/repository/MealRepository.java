package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer> {
    List<Meal> findByRestaurantId(Integer restaurantId);

    List<Meal> findByRestaurantIdAndDate(Integer restaurantId, LocalDate date);
}
