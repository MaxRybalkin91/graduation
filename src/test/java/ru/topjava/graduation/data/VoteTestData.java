package ru.topjava.graduation.data;

import static ru.topjava.graduation.data.RestaurantTestData.*;

public class VoteTestData {

    public static final Integer REST_1_VOTES = 3;
    public static final Integer REST_2_VOTES = 3;
    public static final Integer REST_3_VOTES = 3;

    public static final String REST_1_VOTES_URL = "/restaurants/" + RESTAURANT_1.getId() + "/votes";
    public static final String REST_2_VOTES_URL = "/restaurants/" + RESTAURANT_2.getId() + "/votes";
    public static final String REST_3_VOTES_URL = "/restaurants/" + RESTAURANT_3.getId() + "/votes";
}