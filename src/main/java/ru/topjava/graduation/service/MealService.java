package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.repository.MealRepository;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Meal create(Meal meal, Integer restaurantId) {
        meal.setRestaurant(restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new));
        return mealRepository.save(meal);
    }

    public Meal get(Integer id) {
        return getOrThrowException(id);
    }

    public void delete(Integer id) {
        getOrThrowException(id);
        mealRepository.deleteById(id);
    }

    public List<Meal> getAll(Integer id) {
        return mealRepository.findAllByIdAndDate(id, LocalDate.now());
    }

    private Meal getOrThrowException(Integer id) {
        return mealRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}