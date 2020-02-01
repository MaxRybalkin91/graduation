package ru.topjava.graduation.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.MealService;
import ru.topjava.graduation.web.Controller;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.topjava.graduation.web.Controller.ADMIN_MEALS_URL;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

@RestController
@RequestMapping(value = ADMIN_MEALS_URL, produces = JSON_TYPE)
public class AdminMealController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService mealService;

    @GetMapping("/{id}")
    public Meal get(@PathVariable Integer id,
                    @PathVariable Integer restaurantId,
                    @AuthenticationPrincipal User user) {
        log.info("get meal with id {} of restaurant{} of user {}", id, restaurantId, user.getId());
        return mealService.get(id, restaurantId, user.getId());
    }

    @GetMapping("/history")
    public List<Meal> getHistory(@PathVariable Integer restaurantId,
                                 @AuthenticationPrincipal User user) {
        log.info("get all meals history for restaurant {} of user {}", restaurantId, user.getId());
        return mealService.getHistory(restaurantId, user.getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id,
                       @PathVariable Integer restaurantId,
                       @AuthenticationPrincipal User user) {
        log.info("delete meal with id {} of restaurant {} of user {}", id, restaurantId, user.getId());
        mealService.delete(id, restaurantId, user.getId());
    }

    @PostMapping(consumes = JSON_TYPE)
    public ResponseEntity<Meal> create(@Valid @RequestBody Meal meal,
                                       @PathVariable Integer restaurantId,
                                       @AuthenticationPrincipal User user) {
        log.info("add new meal for a restaurant {} of user {}", restaurantId, user.getId());
        Meal created = mealService.create(meal, restaurantId, user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(MEALS_URL + "/{id}")
                .buildAndExpand(restaurantId, created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @PathVariable Integer restaurantId,
                       @Valid @RequestBody Meal meal,
                       @AuthenticationPrincipal User user) {
        log.info("update meal with id {} of restaurant {} of user {}", id, restaurantId, user.getId());
        mealService.update(id, restaurantId, meal, user);
    }
}