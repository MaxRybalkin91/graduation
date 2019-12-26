package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.put("restaurants", repository.findAll());
        return "restaurants";
    }

    @GetMapping("{restaurant}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String restaurantEditForm(@PathVariable Restaurant restaurant, Model model) {
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("meals", restaurant.getMeals());
        return "restaurantEdit";
    }

    @PostMapping
    public String restaurantSave(
            @RequestParam String name,
            @RequestParam Map<String, String> form,
            @RequestParam("restaurantId") Restaurant restaurant
    ) {
        restaurant.setName(name);
        return "redirect:/restaurants";
    }
}
