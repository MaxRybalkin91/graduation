package ru.topjava.graduation.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.service.MealService;

@RestController
public class MealController {

    @Autowired
    private MealService service;
}
