package ru.topjava.graduation.web;

import org.springframework.http.MediaType;

public interface Controller {

    String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";
    String RESTAURANTS_URL = "/restaurants";
    String MEALS_URL = RESTAURANTS_URL + "/{restaurantId}/meals";
    String VOTES_URL = RESTAURANTS_URL + "/{restaurantId}/votes";
}