package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.service.RestaurantService;
import ru.topjava.graduation.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String REST_URL = "/restaurants";

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    VoteService voteService;

    @GetMapping
    public List<RestaurantTo> getForToday() {
        return restaurantService.getForToday();
    }
}