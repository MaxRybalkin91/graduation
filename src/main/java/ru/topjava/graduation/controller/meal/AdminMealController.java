package ru.topjava.graduation.controller.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.service.MealService;

@RestController
@RequestMapping(value = AdminMealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealController {
    static final String REST_URL = "/meal";

    @Autowired
    private MealService mealService;

    @GetMapping("{mealId}")
    public Meal get(@PathVariable Integer mealId) {
        return mealService.findById(mealId);
    }
}