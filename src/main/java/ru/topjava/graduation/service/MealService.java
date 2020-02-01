package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.MealRepository;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.EditDenyException;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void update(Integer id, Integer restaurantId, Meal meal, User user) {
        getOrThrowException(id, restaurantId, user.getId());
        meal.setId(id);
        create(meal, restaurantId, user);
    }

    public Meal create(Meal meal, Integer restaurantId, User user) {
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        meal.setUser(user);
        return mealRepository.save(meal);
    }

    public void delete(Integer id, Integer restaurantId, Integer userId) {
        mealRepository.deleteByIdAndRestaurantIdAndUserId(id, restaurantId, userId);
    }

    public Meal get(Integer id, Integer restaurantId, Integer userId) {
        return getOrThrowException(id, restaurantId, userId);
    }

    private Meal getOrThrowException(Integer id, Integer restaurantId, Integer userId) {
        Meal meal = mealRepository.findByIdAndRestaurantIdAndUserId(id, restaurantId, userId).orElseThrow(NotFoundException::new);
        if (!meal.getDate().equals(LocalDate.now())) {
            throw new EditDenyException();
        }
        return meal;
    }

    public List<Meal> getHistory(Integer restaurantId, Integer userId) {
        return mealRepository.findAllByRestaurantIdAndUserIdAndDateIsBefore(restaurantId, userId, LocalDate.now());
    }
}