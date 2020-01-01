package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.service.RestaurantService;

import java.util.Map;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

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
    public String voteForRestaurant(@PathVariable Restaurant restaurant, Model model) {
        restaurantService.vote(restaurant);
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
