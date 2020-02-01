package ru.topjava.graduation.web.restaurant;

import org.junit.Test;
import ru.topjava.graduation.web.AbstractControllerTest;

import static ru.topjava.graduation.data.RestaurantTestData.*;
import static ru.topjava.graduation.data.UserTestData.ADMIN_1;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.web.Controller.RESTAURANTS_URL;

public class RestaurantControllerTest extends AbstractControllerTest {

    public RestaurantControllerTest() {
        super(RESTAURANTS_URL);
    }

    @Test
    public void createNotAllowed() throws Exception {
        expectNotAllowed(perform(doPost().jsonBody(getNewRestaurant()).basicAuth(ADMIN_1)));
    }

    @Test
    public void deleteNotAllowed() throws Exception {
        expectNotAllowed(perform(doDelete().basicAuth(ADMIN_1)));
    }

    @Test
    public void getAllForUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet()));
    }

    @Test
    public void getAllForUser() throws Exception {
        getAllEntities(null, USER, TODAY_RESTAURANTS, RESTAURANTS_TO_MATCHERS);
    }

    @Test
    public void getAllForAdmin() throws Exception {
        getAllEntities(null, ADMIN_1, TODAY_RESTAURANTS, RESTAURANTS_TO_MATCHERS);
    }
}