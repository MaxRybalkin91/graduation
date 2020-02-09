package ru.topjava.graduation.web;

import org.springframework.http.MediaType;

public interface Controller {

    String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

    String RESTAURANTS_URL = "/restaurants";
    String MEALS_URL = "/restaurants/{restaurantId}/meals";
    String VOTES_URL = "/restaurants/{restaurantId}/votes";

    String OWNER_RESTAURANTS_URL = "/my" + RESTAURANTS_URL;
    String OWNER_MEALS_URL = "/my" + MEALS_URL;
    String OWNER_HISTORY_MEALS_URL = "/my" + MEALS_URL + "/history";
    String OWNER_FUTURE_MEALS_URL = "/my" + MEALS_URL + "/future";
    String OWNER_VOTES_URL = "/my" + VOTES_URL;

    String REGISTER_URL = "/register";
    String PROFILE_URL = "/profile";

    String USER_LIST_URL = "/admin/users";
    String OWNER_LIST_URL = "/admin/owners";
}