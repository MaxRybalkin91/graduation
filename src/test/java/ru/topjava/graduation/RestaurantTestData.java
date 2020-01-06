package ru.topjava.graduation;

import ru.topjava.graduation.model.dto.RestaurantTo;

import java.util.ArrayList;
import java.util.List;

import static ru.topjava.graduation.MealTestData.*;

public class RestaurantTestData {

    public static final List<RestaurantTo> RESTAURANTS_FROM_DB = new ArrayList<>() {{
        add(new RestaurantTo(100003, "Burger King", "ул.Садовая 1", 3, todayMeals1));
        add(new RestaurantTo(100004, "McDonalds", "ул.Центральная 5", 3, todayMeals2));
        add(new RestaurantTo(100005, "KFC", "ул.Пушкина 10", 3, todayMeals3));
    }};
}