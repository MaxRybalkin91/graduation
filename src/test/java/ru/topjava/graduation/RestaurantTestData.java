package ru.topjava.graduation;

import ru.topjava.graduation.model.Restaurant;

public class RestaurantTestData extends AbstractTestData {
    public static final Restaurant RESTAURANT_1 = new Restaurant(START_SEQ + 3, "Burger King", "ул.Садовая 1");
    public static final Restaurant RESTAURANT_2 = new Restaurant(START_SEQ + 4, "McDonalds", "ул.Центральная 5");
    public static final Restaurant RESTAURANT_3 = new Restaurant(START_SEQ + 5, "KFC", "ул.Пушкина 10");
}