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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {
    static final String REST_URL = "/meals";

    @Autowired
    private MealService mealService;

    @GetMapping("/{restaurantId}")
    public List<Meal> getToday(@PathVariable Integer restaurantId) {
        return mealService.findByRestaurantIdAndDate(restaurantId, LocalDate.now());
    }

    @GetMapping("/{restaurantId}_all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Meal> getAll(@PathVariable Integer restaurantId) {
        return mealService.findByRestaurantId(restaurantId);
    }
}