package ru.topjava.graduation.data;

import ru.topjava.graduation.TestMatchers;
import ru.topjava.graduation.dto.RestaurantTo;
import ru.topjava.graduation.model.Restaurant;

import java.util.List;
import java.util.Set;

import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.UserTestData.*;

public class RestaurantTestData {
    public static final Integer REST_1_ID = 11;
    public static final Integer REST_2_ID = 12;
    public static final Integer REST_3_ID = 13;

    public static final Restaurant RESTAURANT_1 = new Restaurant(REST_1_ID, "Burger King", "ул.Садовая 1", OWNER_1);
    public static final Restaurant RESTAURANT_2 = new Restaurant(REST_2_ID, "McDonalds", "ул.Центральная 5", OWNER_2);
    public static final Restaurant RESTAURANT_3 = new Restaurant(REST_3_ID, "KFC", "ул.Пушкина 10", OWNER_3);

    public static final RestaurantTo RESTAURANT_TO_1 = new RestaurantTo(RESTAURANT_1, Set.of(MEAL_1, MEAL_2, MEAL_3));
    public static final RestaurantTo RESTAURANT_TO_2 = new RestaurantTo(RESTAURANT_2, Set.of(MEAL_4, MEAL_5));
    public static final RestaurantTo RESTAURANT_TO_3 = new RestaurantTo(RESTAURANT_3, Set.of(MEAL_6, MEAL_7));

    public static final List<RestaurantTo> TODAY_RESTAURANTS = List.of(RESTAURANT_TO_1, RESTAURANT_TO_2, RESTAURANT_TO_3);

    public static final Restaurant INVALID_RESTAURANT = new Restaurant(REST_3_ID, null, null);

    public static final List<Restaurant> OWNER_1_RESTAURANTS = List.of(RESTAURANT_1);

    public static TestMatchers<Restaurant> RESTAURANTS_MATCHERS = TestMatchers.useFieldsComparator(Restaurant.class, "meals", "user");

    public static TestMatchers<RestaurantTo> RESTAURANTS_TO_MATCHERS = TestMatchers.useFieldsComparator(RestaurantTo.class);

    public static Restaurant getNewRestaurant() {
        return new Restaurant("Пиццерия", "пр.Академиков 15");
    }

    public static Restaurant getUpdatedRestaurant() {
        Restaurant updated = new Restaurant();
        updated.setId(REST_1_ID);
        updated.setName("NEW NAME");
        updated.setAddress("NEW ADDRESS");
        return updated;
    }
}