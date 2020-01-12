package ru.topjava.graduation.controller.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.service.MealService;

import java.util.List;

@RestController
@RequestMapping(value = MealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class MealController {
    static final String REST_URL = "/meals";

    @Autowired
    private MealService mealService;

    @GetMapping("/mealsOf{restaurant}")
    public List<Meal> getAllForToday(@PathVariable("restaurant") Integer id) {
        return mealService.getForToday(id);
    }
}