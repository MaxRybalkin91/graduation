package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Meal;

public interface MealRepository extends CrudRepository<Meal, Integer> {

}