package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.repository.MealRepository;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.EditDenyException;
import ru.topjava.graduation.util.exception.InvalidSaveException;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void update(Integer id, Integer restaurantId, Meal meal) {
        getOrThrowException(id, restaurantId, new InvalidSaveException());
        meal.setId(id);
        create(meal, restaurantId);
    }

    public Meal create(Meal meal, Integer restaurantId) {
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return mealRepository.save(meal);
    }

    public void delete(Integer id, Integer restaurantId) {
        mealRepository.deleteByIdAndRestaurantId(id, restaurantId);
    }

    public Meal get(Integer id, Integer restaurantId) {
        return getOrThrowException(id, restaurantId, new NotFoundException());
    }

    private Meal getOrThrowException(Integer id, Integer restaurantId, RuntimeException exception) {
        Meal meal = mealRepository.findByIdAndRestaurantId(id, restaurantId).orElseThrow(() -> exception);
        if (!meal.getDate().equals(LocalDate.now())) {
            throw new EditDenyException();
        }
        return meal;
    }

    public List<Meal> getHistory(Integer restaurantId) {
        return mealRepository.findAllByRestaurantIdAndDateIsBefore(restaurantId, LocalDate.now());
    }
}