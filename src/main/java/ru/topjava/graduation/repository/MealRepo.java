package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Meal;

import java.util.List;

public interface MealRepo extends CrudRepository<Meal, Integer> {
    List<Meal> findByRestaurantId(Integer restaurant_id);
}
