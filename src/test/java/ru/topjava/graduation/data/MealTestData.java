package ru.topjava.graduation.data;

import ru.topjava.graduation.TestMatchers;
import ru.topjava.graduation.model.Meal;

import java.util.List;

import static ru.topjava.graduation.data.RestaurantTestData.*;

public class MealTestData {
    private static final Integer START_SEQ = 100000;

    public static final Meal MEAL_1 = new Meal(START_SEQ + 6, "ChickenBurger set", 300, RESTAURANT_1);
    public static final Meal MEAL_2 = new Meal(START_SEQ + 7, "CheeseBurger set", 400, RESTAURANT_1);
    public static final Meal MEAL_3 = new Meal(START_SEQ + 8, "FishBurger set", 500, RESTAURANT_1);

    public static final Meal MEAL_4 = new Meal(START_SEQ + 9, "BigMac set", 300, RESTAURANT_2);
    public static final Meal MEAL_5 = new Meal(START_SEQ + 10, "Happy Meal set", 400, RESTAURANT_2);

    public static final Meal MEAL_6 = new Meal(START_SEQ + 11, "Sanders lunch basket", 300, RESTAURANT_3);
    public static final Meal MEAL_7 = new Meal(START_SEQ + 12, "Lunch basket \"5 items\"", 400, RESTAURANT_3);

    public static final List<Meal> RESTAURANT_1_MEALS = List.of(MEAL_1, MEAL_2, MEAL_3);
    public static final List<Meal> RESTAURANT_2_MEALS = List.of(MEAL_4, MEAL_5);
    public static final List<Meal> RESTAURANT_3_MEALS = List.of(MEAL_6, MEAL_7);

    public static TestMatchers<Meal> MEAL_MATCHERS = TestMatchers.useEquals(Meal.class);

    public static Meal getNewMeal() {
        return new Meal("Big Mexican Burger", 199);
    }

    public static Meal getUpdatedMeal() {
        Meal updated = new Meal();
        updated.setId(MEAL_1.getId());
        updated.setName("Today's new burger");
        updated.setPrice(200);
        updated.setRestaurant(RESTAURANT_1);
        return updated;
    }
}