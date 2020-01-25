package ru.topjava.graduation.web.meal;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import ru.topjava.graduation.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.UserTestData.ADMIN;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;
import static ru.topjava.graduation.web.Controller.MEALS_URL;

public class MealControllerTest extends AbstractControllerTest {

    public MealControllerTest() {
        super(MEALS_URL);
    }

    @Test
    public void createFromAnotherMapping() throws Exception {
        perform(doPost().jsonBody(getNewMeal())
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
                .andExpect(MEAL_MATCHERS.contentJson(RESTAURANT_1_MEALS));
    }
}