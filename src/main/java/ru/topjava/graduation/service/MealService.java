package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.repository.MealRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal findById(Integer mealId) {
        return mealRepository.findById(mealId).orElseThrow(NotFoundException::new);
    }
}