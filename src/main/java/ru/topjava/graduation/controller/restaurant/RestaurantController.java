package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.service.RestaurantService;
import ru.topjava.graduation.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String REST_URL = "/restaurants";

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VoteService voteService;

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{restaurant}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Restaurant restaurantEditForm(@PathVariable("restaurant") Integer id) {
        return restaurantService.findById(id);
    }

    @DeleteMapping("/{restaurant}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurant") Integer id) {
        restaurantService.deleteById(id);
    }
}