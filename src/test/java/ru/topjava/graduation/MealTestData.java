package ru.topjava.graduation;

import ru.topjava.graduation.model.dto.MealTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MealTestData {
    public static List<MealTo> todayMeals1 = new ArrayList<>() {{
        add(new MealTo(100006, "ChickenBurger set", 300, LocalDate.now()));
        add(new MealTo(100007, "CheeseBurger set", 400, LocalDate.now()));
        add(new MealTo(100008, "FishBurger set", 500, LocalDate.now()));
    }};

    public static List<MealTo> todayMeals2 = new ArrayList<>() {{
        add(new MealTo(100009, "BigMac set", 300, LocalDate.now()));
        add(new MealTo(100010, "Happy Meal set", 400, LocalDate.now()));
    }};

    public static List<MealTo> todayMeals3 = new ArrayList<>() {{
        add(new MealTo(100011, "Sanders lunch basket", 300, LocalDate.now()));
        add(new MealTo(100012, "Lunch basket \"5 items\"", 400, LocalDate.now()));
    }};
}