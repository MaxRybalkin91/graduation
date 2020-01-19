package ru.topjava.graduation.web;

import org.springframework.http.MediaType;

public interface Controller {

    String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";
    String RESTAURANTS_URL = "/restaurants";
    String MEALS_URL = "/restaurants/{restaurantId}/meals";
    String VOTE_URL = "/restaurants/{restaurantId}/votes";
}