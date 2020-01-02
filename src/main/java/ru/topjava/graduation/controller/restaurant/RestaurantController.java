package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.RestaurantService;
import ru.topjava.graduation.service.VoteService;

import java.util.Map;

import static ru.topjava.graduation.util.CurrentTimeUtil.isTimeOver;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VoteService voteService;

    @GetMapping
    public String getAll(Map<String, Object> model) {
        model.put("restaurants", restaurantService.findAll());
        return "restaurants";
    }

    @GetMapping("{restaurant}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String restaurantEditForm(@PathVariable Restaurant restaurant, Model model) {
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("meals", restaurant.getMeals());
        return "restaurantEdit";
    }

    @GetMapping("{restaurant}/vote")
    public String voteForRestaurant(@PathVariable Restaurant restaurant,
                                    @AuthenticationPrincipal User user,
                                    Map<String, Object> model) {
        if (voteService.isUserVoted(user) && isTimeOver()) {
            model.put("message", "You have already voted today!");
            model.put("restaurants", restaurantService.findAll());
            return "restaurants";
        }
        voteService.vote(restaurant, user);
        return "redirect:/restaurants";
    }

    @PostMapping
    public String restaurantSave(
            @RequestParam String name,
            @RequestParam("restaurantId") Restaurant restaurant
    ) {
        restaurant.setName(name);
        return "redirect:/restaurants";
    }
}