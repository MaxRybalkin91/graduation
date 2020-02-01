package ru.topjava.graduation.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.RestaurantService;
import ru.topjava.graduation.web.Controller;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.topjava.graduation.web.Controller.ADMIN_RESTAURANTS_URL;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

@RestController
@RequestMapping(value = ADMIN_RESTAURANTS_URL, produces = JSON_TYPE)
public class AdminRestaurantController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getMyRestaurants(@AuthenticationPrincipal User user) {
        log.info("get all the restaurants of user {}", user.getId());
        return restaurantService.getAll(user.getId());
    }

    @GetMapping("/{restaurantId}")
    public Restaurant get(@PathVariable Integer restaurantId,
                          @AuthenticationPrincipal User user) {
        log.info("get restaurant with id {} of user {}", restaurantId, user.getId());
        return restaurantService.get(restaurantId, user.getId());
    }

    @PostMapping(consumes = JSON_TYPE)
    public ResponseEntity<Restaurant> create(@Valid @RequestBody Restaurant restaurant,
                                             @AuthenticationPrincipal User user) {
        log.info("creating new restaurant for user {}", user.getId());
        Restaurant created = restaurantService.create(restaurant, user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(RESTAURANTS_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer restaurantId,
                       @AuthenticationPrincipal User user) {
        log.info("delete restaurant with id {} of user {}", restaurantId, user.getId());
        restaurantService.delete(restaurantId, user.getId());
    }

    @PutMapping("/{restaurantId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer restaurantId,
                       @Valid @RequestBody Restaurant restaurant,
                       @AuthenticationPrincipal User user) {
        log.info("update restaurant with id {} of user {}", restaurantId, user.getId());
        restaurantService.update(restaurantId, restaurant, user);
    }
}