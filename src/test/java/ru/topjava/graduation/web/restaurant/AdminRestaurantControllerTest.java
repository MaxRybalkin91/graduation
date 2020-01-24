package ru.topjava.graduation.web.restaurant;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.service.RestaurantService;
import ru.topjava.graduation.util.exception.NotFoundException;
import ru.topjava.graduation.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.RestaurantTestData.*;
import static ru.topjava.graduation.TestUtil.readFromJson;
import static ru.topjava.graduation.TestUtil.readFromJsonMvcResult;
import static ru.topjava.graduation.web.Controller.ADMIN_RESTAURANTS_URL;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

public class AdminRestaurantControllerTest extends AbstractControllerTest {

    public AdminRestaurantControllerTest() {
        super(ADMIN_RESTAURANTS_URL);
    }

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void create() throws Exception {
        RestaurantTo newRestaurant = new RestaurantTo(getNewRestaurant());
        ResultActions action = perform(doPost().jsonBody(newRestaurant).basicAuth(ADMIN));

        RestaurantTo created = readFromJson(action, RestaurantTo.class);
        Integer newId = created.getId();
        newRestaurant.setId(newId);
        RESTAURANTS_TO_MATCHERS.assertMatch(created, newRestaurant);
        RESTAURANTS_TO_MATCHERS.assertMatch(restaurantService.get(newId), newRestaurant);
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
    public void createExists() throws Exception {
        perform(doPost().jsonBody(RESTAURANT_1).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void delete() throws Exception {
        Integer rest_id = RESTAURANT_1.getId();
        perform(doDelete(rest_id).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> restaurantService.get(rest_id));
    }

    @Test
    public void deleteUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(RESTAURANT_1.getId())));
    }

    @Test
    public void deleteNotAdmin() throws Exception {
        expectForbidden(perform(doDelete(RESTAURANT_1.getId()).basicAuth(USER)));
    }

    @Test
    public void get() throws Exception {
        perform(doGet(RESTAURANT_1.getId()).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_TYPE))
                .andExpect(result -> RESTAURANTS_TO_MATCHERS.assertMatch(readFromJsonMvcResult(result, RestaurantTo.class), new RestaurantTo(RESTAURANT_1)));
    }

    @Test
    public void getUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(RESTAURANT_1.getId())));
    }

    @Test
    public void getForNotAdmin() throws Exception {
        expectForbidden(perform(doGet(RESTAURANT_1.getId()).basicAuth(USER)));
    }
}