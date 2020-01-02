package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.repository.MealRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> findByRestaurantId(Integer restaurantId) {
        return mealRepository.findByRestaurantId(restaurantId);
    }

    public List<Meal> findByRestaurantIdAndDate(Integer restaurantId, LocalDate date) {
        return mealRepository.findByRestaurantIdAndDate(restaurantId, date);
    }
}