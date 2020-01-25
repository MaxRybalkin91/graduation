package ru.topjava.graduation.web.restaurant;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import ru.topjava.graduation.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.RestaurantTestData.*;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;
import static ru.topjava.graduation.web.Controller.RESTAURANTS_URL;

public class RestaurantControllerTest extends AbstractControllerTest {

    public RestaurantControllerTest() {
        super(RESTAURANTS_URL);
    }

    @Test
    public void createFromAnotherMapping() throws Exception {
        perform(doPost().jsonBody(getNewRestaurant())
                .basicAuth(ADMIN))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void deleteFromAnotherMapping() throws Exception {
        perform(doDelete()
                .basicAuth(ADMIN))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void getAllUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet()));
    }

    @Test
    public void getAllUser() throws Exception {
        getAll(perform(doGet().basicAuth(USER)));
    }

    @Test
    public void getAllAdmin() throws Exception {
        getAll(perform(doGet().basicAuth(ADMIN)));
    }

    private void getAll(ResultActions resultActions) throws Exception {
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_TYPE))
                .andExpect(RESTAURANTS_TO_MATCHERS.contentJson(RESTAURANTS));
    }
}