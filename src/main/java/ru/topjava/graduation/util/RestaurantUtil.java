package ru.topjava.graduation.util;

import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtil {
    public static List<RestaurantTo> restaurantTos(List<Restaurant> list) {
        return list.stream().map(RestaurantTo::new).collect(Collectors.toList());
    }
}