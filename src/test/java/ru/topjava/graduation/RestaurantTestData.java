package ru.topjava.graduation;

import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTestData extends AbstractTestData {
    public static final Restaurant RESTAURANT_1 = new Restaurant(START_SEQ + 3, "Burger King", "ул.Садовая 1");
    public static final Restaurant RESTAURANT_2 = new Restaurant(START_SEQ + 4, "McDonalds", "ул.Центральная 5");
    public static final Restaurant RESTAURANT_3 = new Restaurant(START_SEQ + 5, "KFC", "ул.Пушкина 10");

    public static final List<RestaurantTo> RESTAURANTS = List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3)
            .stream()
            .map(RestaurantTo::new)
            .collect(Collectors.toList());

    public static TestMatchers<RestaurantTo> RESTAURANTS_TO_MATCHERS = TestMatchers.useEquals(RestaurantTo.class);

    public static Restaurant getNewRestaurant() {
        return new Restaurant("Пиццерия", "пр.Академиков 15");
    }

    public static Restaurant getUpdatedRestaurant() {
        Restaurant updated = new Restaurant();
        updated.setId(RESTAURANT_1.getId());
        updated.setName("NEW NAME");
        updated.setAddress("NEW ADDRESS");
        return updated;
    }
}