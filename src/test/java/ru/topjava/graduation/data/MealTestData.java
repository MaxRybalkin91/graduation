package ru.topjava.graduation.data;

import ru.topjava.graduation.TestMatchers;
import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.List;

import static ru.topjava.graduation.data.RestaurantTestData.RESTAURANT_1;
import static ru.topjava.graduation.data.RestaurantTestData.REST_1_ID;
import static ru.topjava.graduation.data.UserTestData.ADMIN_1;
import static ru.topjava.graduation.data.UserTestData.ADMIN_2;

public class MealTestData {

    public static final Integer MEAL_1_ID = 21;
    public static final Integer MEAL_2_ID = 22;
    public static final Integer MEAL_3_ID = 23;
    public static final Integer MEAL_4_ID = 24;
    public static final Integer MEAL_5_ID = 25;
    public static final Integer MEAL_6_ID = 26;
    public static final Integer MEAL_7_ID = 27;

    public static final Meal MEAL_1 = new Meal(MEAL_1_ID, "ChickenBurger set", 300, ADMIN_1);
    public static final Meal MEAL_2 = new Meal(MEAL_2_ID, "CheeseBurger set", 400, ADMIN_1);
    public static final Meal MEAL_3 = new Meal(MEAL_3_ID, "FishBurger set", 500, ADMIN_1);

    public static final Meal MEAL_4 = new Meal(MEAL_4_ID, "BigMac set", 300, ADMIN_2);
    public static final Meal MEAL_5 = new Meal(MEAL_5_ID, "Happy Meal set", 400, ADMIN_2);

    public static final Meal MEAL_6 = new Meal(MEAL_6_ID, "Sanders lunch basket", 300, ADMIN_2);
    public static final Meal MEAL_7 = new Meal(MEAL_7_ID, "Lunch basket \"5 items\"", 400, ADMIN_2);

    public static final Meal INVALID_MEAL = new Meal(MEAL_1.getName(), null);

    public static final Meal OLD_MEAL_1_REST_1 = new Meal(111, "Lunch1_1", 300, LocalDate.of(2019, 5, 31));
    public static final Meal OLD_MEAL_2_REST_1 = new Meal(112, "Lunch2_1", 300, LocalDate.of(2019, 5, 31));
    public static final Meal OLD_MEAL_3_REST_1 = new Meal(113, "Lunch3_1", 300, LocalDate.of(2019, 5, 31));

    public static final List<Meal> RESTAURANT_1_HISTORY = List.of(OLD_MEAL_1_REST_1, OLD_MEAL_2_REST_1, OLD_MEAL_3_REST_1);

    public static final String REST_1_MEALS_URL = "/restaurants/" + REST_1_ID + "/meals";

    public static final String ADMIN_REST_1_MEALS_URL = "/admin" + REST_1_MEALS_URL;

    public static TestMatchers<Meal> MEAL_MATCHERS = TestMatchers.useFieldsComparator(Meal.class, "restaurant", "user");

    public static TestMatchers<Meal> MEAL_HISTORY_MATCHERS = TestMatchers.useFieldsComparator(Meal.class, "restaurant", "user", "date");


    public static Meal getNewMeal() {
        return new Meal("Big Mexican Burger", 199);
    }

    public static Meal getUpdatedMeal() {
        Meal updated = new Meal();
        updated.setId(MEAL_1_ID);
        updated.setName("Today's new burger");
        updated.setPrice(200);
        updated.setRestaurant(RESTAURANT_1);
        return updated;
    }
}