package ru.topjava.graduation;

import ru.topjava.graduation.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealTestData {
    public static List<Meal> todayMeals1 = new ArrayList<>() {{
        add(new Meal(100006, "ChickenBurger set", 300));
        add(new Meal(100007, "CheeseBurger set", 400));
        add(new Meal(100008, "FishBurger set", 500));
    }};

    public static List<Meal> todayMeals2 = new ArrayList<>() {{
        add(new Meal(100009, "BigMac set", 300));
        add(new Meal(100010, "Happy Meal set", 400));
    }};

    public static List<Meal> todayMeals3 = new ArrayList<>() {{
        add(new Meal(100011, "Sanders lunch basket", 300));
        add(new Meal(100012, "Lunch basket \"5 items\"", 400));
    }};
}