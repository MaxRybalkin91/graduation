package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.repository.RestaurantRepo;

import java.util.Map;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantRepo repository;

    @GetMapping
    public String getAll(Map<String, Object> model) {
        Iterable<Restaurant> restaurants = repository.findAll();
        model.put("restaurants", restaurants);
        return "/restaurants";
    }

    @PostMapping
    public void create(@RequestParam String name, @RequestParam String address, Map<String, Object> model) {
        Restaurant restaurant = new Restaurant(name, address);
        repository.save(restaurant);
        getAll(model);
    }

    @PostMapping("filterName")
    public String filterByName(@RequestParam String name, Map<String, Object> model) {
        Iterable<Restaurant> restaurants;

        if (name != null && !name.isEmpty()) {
            restaurants = repository.findByName(name);
        } else {
            return "redirect:/restaurants";
        }
        model.put("restaurants", restaurants);
        return "/restaurants";
    }

    @PostMapping("filterAddress")
    public String filterByAddress(@RequestParam String address, Map<String, Object> model) {
        Iterable<Restaurant> restaurants;

        if (address != null && !address.isEmpty()) {
            restaurants = repository.findByAddress(address);
        } else {
            return "redirect:/restaurants";
        }
        model.put("restaurants", restaurants);
        return "/restaurants";
    }
}
