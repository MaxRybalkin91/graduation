package ru.topjava.graduation.controller.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.service.MealService;

import java.util.List;

@RestController
@RequestMapping(value = AdminMealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminMealController {
    static final String REST_URL = "/meal";

    @Autowired
    private MealService mealService;

    @GetMapping("{mealId}")
    public Meal getOne(@PathVariable Integer mealId) {
        return mealService.findById(mealId);
    }

    @GetMapping("/{restaurant}")
    public List<Meal> getAllForRestaurant(@PathVariable("restaurant") Integer id) {
        return mealService.findAllForRestaurant(id);
    }
}