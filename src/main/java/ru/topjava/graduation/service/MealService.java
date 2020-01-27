package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(value = "meals", allEntries = true)
    public void update(Integer id, Integer restaurantId, Meal meal) {
        getOrThrowException(id, restaurantId, new InvalidSaveException());
        meal.setId(id);
        create(meal, restaurantId);
    }

    @CacheEvict(value = "meals", allEntries = true)
    public Meal create(Meal meal, Integer restaurantId) {
        meal.setRestaurant(restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new));
        return mealRepository.save(meal);
    }

    @CacheEvict(value = "meals", allEntries = true)
    public void delete(Integer id, Integer restaurantId) {
        get(id, restaurantId);
        mealRepository.deleteById(id);
    }

    public Meal get(Integer id, Integer restaurantId) {
        return getOrThrowException(id, restaurantId, new NotFoundException());
    }

    @Cacheable("meals")
    public List<Meal> getAll(Integer restaurantId) {
        return mealRepository.findAllByRestaurantIdAndDate(restaurantId, LocalDate.now());
    }

    private Meal getOrThrowException(Integer id, Integer restaurantId, RuntimeException exception) {
        Meal meal = mealRepository.findByIdAndRestaurantId(id, restaurantId).orElseThrow(() -> exception);
        if (!meal.getDate().equals(LocalDate.now())) {
            throw new EditDenyException();
        }
        return meal;
    }

    public List<Meal> getHistory(Integer restaurantId) {
        return mealRepository.findAllByRestaurantId(restaurantId);
    }
}