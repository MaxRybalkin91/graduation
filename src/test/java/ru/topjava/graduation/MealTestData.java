package ru.topjava.graduation;

import ru.topjava.graduation.model.Meal;

import static ru.topjava.graduation.RestaurantTestData.*;

public class MealTestData extends AbstractTestData {
    public static final Meal MEAL_1 = new Meal(START_SEQ + 6, "ChickenBurger set", 300, RESTAURANT_1);
    public static final Meal MEAL_2 = new Meal(START_SEQ + 7, "CheeseBurger set", 400, RESTAURANT_1);
    public static final Meal MEAL_3 = new Meal(START_SEQ + 8, "FishBurger set", 500, RESTAURANT_1);

    public static final Meal MEAL_4 = new Meal(START_SEQ + 9, "BigMac set", 300, RESTAURANT_2);
    public static final Meal MEAL_5 = new Meal(START_SEQ + 10, "Happy Meal set", 400, RESTAURANT_2);

    public static final Meal MEAL_6 = new Meal(START_SEQ + 11, "Sanders lunch basket", 300, RESTAURANT_3);
    public static final Meal MEAL_7 = new Meal(START_SEQ + 12, "Lunch basket \"5 items\"", 400, RESTAURANT_3);

}