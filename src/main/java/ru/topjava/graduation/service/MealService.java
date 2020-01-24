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

    public Meal create(Meal meal, Integer id) {
        meal.setRestaurant(restaurantRepository.findById(id).orElseThrow(NotFoundException::new));
        return mealRepository.save(meal);
    }

    public Meal get(Integer id) {
        return mealRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Integer id) {
        mealRepository.deleteById(id);
    }


    public List<Meal> getAll(Integer id) {
        return mealRepository.findAllByidAndDate(id, LocalDate.now());
    }
}