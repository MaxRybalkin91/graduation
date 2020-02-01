package ru.topjava.graduation.data;

import ru.topjava.graduation.TestMatchers;
import ru.topjava.graduation.model.dto.VoteToDate;

import java.time.LocalDate;
import java.util.List;

import static ru.topjava.graduation.data.RestaurantTestData.REST_1_ID;
import static ru.topjava.graduation.data.RestaurantTestData.REST_2_ID;

public class VoteTestData {

    public static final Integer REST_1_VOTES = 6;
    public static final Integer REST_2_VOTES = 6;
    public static final Integer REST_3_VOTES = 6;

    public static final List<VoteToDate> VOTES_TO_RESTAURANT_1 = List.of(
            new VoteToDate(LocalDate.of(2019, 5, 29), 2L),
            new VoteToDate(LocalDate.of(2019, 5, 30), 2L),
            new VoteToDate(LocalDate.of(2019, 5, 31), 2L)
    );

    public static final String REST_1_VOTES_URL = "/restaurants/" + REST_1_ID + "/votes";
    public static final String REST_2_VOTES_URL = "/restaurants/" + REST_2_ID + "/votes";

    public static final String ADMIN_1_VOTES_URL = "/admin" + REST_1_VOTES_URL;

    public static TestMatchers<VoteToDate> VOTE_TO_MATCHERS = TestMatchers.useEquals(VoteToDate.class);
}