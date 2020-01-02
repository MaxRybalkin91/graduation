package ru.topjava.graduation.controller.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.repository.MealRepository;

import java.util.Map;

@Controller
@RequestMapping(value = "/meals")
public class MealController {
    @Autowired
    private MealRepository repository;

    @GetMapping
    public String getAll(@RequestParam Integer id, Map<String, Object> model) {
        Iterable<Meal> meals = repository.findByRestaurantId(id);
        model.put("meals", meals);
        return "meals";
    }

    @PostMapping
    public void create(@RequestParam String description,
                       @RequestParam Integer price,
                       @RequestParam Restaurant restaurant,
                       Map<String, Object> model) {
        Meal meal = new Meal(description, price, restaurant);
        repository.save(meal);
        getAll(restaurant.getId(), model);
    }

    @PutMapping
    public void update(@RequestParam String description,
                       @RequestParam Integer price,
                       @RequestParam Integer id,
                       Map<String, Object> model) {
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id,
                       @RequestParam Restaurant restaurant,
                       Map<String, Object> model) {
        repository.deleteById(id);
        getAll(restaurant.getId(), model);
    }
}
