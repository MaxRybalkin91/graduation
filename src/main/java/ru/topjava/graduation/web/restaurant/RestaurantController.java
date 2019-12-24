package ru.topjava.graduation.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.service.RestaurantService;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public String main(Map<String, Object> model) {
        return null;
    }

    @PostMapping
    public String create(@RequestParam String name, @RequestParam String address, Map<String, Object> model) {
        Restaurant restaurant = new Restaurant(name, address);
        return null;
    }

    @PutMapping
    public String update(@RequestParam String name, @RequestParam String address, Map<String, Object> model) {
        Restaurant restaurant = new Restaurant(name, address);
        return null;
    }

    @PostMapping("filterName")
    public String filterByName(@RequestParam String name, Map<String, Object> model) {
        Iterable<Restaurant> restaurants;
        if (!Objects.isNull(name)) {

        }
        model.put("restaurants", null);
        return null;
    }

    @PostMapping("filterAddress")
    public String filterByAddress(@RequestParam String address, Map<String, Object> model) {
        Iterable<Restaurant> restaurants;
        if (!Objects.isNull(address)) {

        }
        model.put("restaurants", null);
        return null;
    }
}