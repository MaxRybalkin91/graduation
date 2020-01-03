package ru.topjava.graduation.controller.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminRestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/{restaurant}")
    public Restaurant restaurantEditForm(@PathVariable("restaurant") Integer id) {
        return restaurantService.findById(id);
    }

    @DeleteMapping("/{restaurant}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurant") Integer id) {
        restaurantService.deleteById(id);
    }
}
