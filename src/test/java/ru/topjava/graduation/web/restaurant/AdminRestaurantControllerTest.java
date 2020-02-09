package ru.topjava.graduation.web.restaurant;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.web.AbstractControllerTest;

import static ru.topjava.graduation.data.RestaurantTestData.*;
import static ru.topjava.graduation.data.UserTestData.OWNER_1;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.web.Controller.OWNER_RESTAURANTS_URL;

public class AdminRestaurantControllerTest extends AbstractControllerTest {

    public AdminRestaurantControllerTest() {
        super(OWNER_RESTAURANTS_URL);
    }

    @Test
    public void createUnauthorized() throws Exception {
        expectUnauthorized(perform(doPost().jsonBody(getNewRestaurant())));
    }

    @Test
    public void createNotAdmin() throws Exception {
        expectForbidden(perform(doPost().jsonBody(getNewRestaurant()).basicAuth(USER)));
    }

    @Test
    public void deleteUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(REST_1_ID)));
    }

    @Test
    public void deleteNotAdmin() throws Exception {
        expectForbidden(perform(doDelete(REST_1_ID).basicAuth(USER)));
    }

    @Test
    public void getUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(REST_1_ID)));
    }

    @Test
    public void getNotAdmin() throws Exception {
        expectForbidden(perform(doGet(REST_1_ID).basicAuth(USER)));
    }

    @Test
    public void create() throws Exception {
        createNew(getNewRestaurant(), RESTAURANTS_MATCHERS);
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void createExists() throws Exception {
        Restaurant duplicated = new Restaurant(null, RESTAURANT_1.getName(), RESTAURANT_1.getAddress());
        expectDuplicated(perform(doPost().jsonBody(duplicated).basicAuth(OWNER_1)));
    }

    @Test
    public void createInvalid() throws Exception {
        Restaurant invalid = new Restaurant(RESTAURANT_1.getName(), null);
        expectInvalidEntity(perform(doPost().jsonBody(invalid).basicAuth(OWNER_1)));
    }

    @Test
    public void delete() throws Exception {
        deleteAndCheck(REST_1_ID);
    }

    @Test
    public void get() throws Exception {
        getOne(RESTAURANT_1, RESTAURANTS_MATCHERS);
    }

    @Test
    public void getMy() throws Exception {
        getAllEntities(null, OWNER_1, OWNER_1_RESTAURANTS, RESTAURANTS_MATCHERS);
    }

    @Test
    public void getAlien() throws Exception {
        expectNotFound(perform(doGet(REST_2_ID).basicAuth(OWNER_1)));
    }

    @Test
    public void update() throws Exception {
        update(REST_1_ID, getUpdatedRestaurant(), RESTAURANTS_MATCHERS);
    }

    @Test
    public void updateInvalid() throws Exception {
        expectInvalidEntity(perform(doPut(REST_3_ID).jsonBody(INVALID_RESTAURANT).basicAuth(OWNER_1)));
    }
}