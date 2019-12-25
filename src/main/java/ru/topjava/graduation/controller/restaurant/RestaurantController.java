package ru.topjava.graduation.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    public void vote(@RequestParam Integer id, Map<String, Object> model) {
        repository.findById(id);
        getAll(model);
    }
}
