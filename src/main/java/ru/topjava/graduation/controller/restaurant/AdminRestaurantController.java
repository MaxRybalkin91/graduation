package ru.topjava.graduation.controller.restaurant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.service.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/all")
    public List<RestaurantTo> getAll() {
        log.info("get all the restaurants with all the meals");
        return restaurantService.getAll();
    }

    @GetMapping("/{restaurant}")
    public Restaurant restaurantEditForm(@PathVariable("restaurant") Integer id) {
        log.info("get restaurant with id {}", id);
        return restaurantService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantTo create(@Valid @RequestBody Restaurant restaurant) {
        log.info("create new restaurant");
        return restaurantService.create(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody @PathVariable("id") Restaurant restaurant) {
        log.info("update restaurant with id {}", restaurant.getId());
        restaurantService.create(restaurant);
    }

    @DeleteMapping("/{restaurant}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurant") Integer id) {
        log.info("delete restaurant with id {}", id);
        restaurantService.deleteById(id);
    }
}