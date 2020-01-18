package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.topjava.graduation.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}