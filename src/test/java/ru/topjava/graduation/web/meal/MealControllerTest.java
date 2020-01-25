package ru.topjava.graduation.web.meal;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.web.AbstractControllerTest;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.UserTestData.ADMIN;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

public class MealControllerTest extends AbstractControllerTest {

    public MealControllerTest() {
        super(RESTAURANT_1_MEALS_URL);
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
        expectUnauthorized(perform(doGet(RESTAURANT_3_MEALS_URL)));
    }

    @Test
    public void getAllUser() throws Exception {
        getAll(perform(doGet(RESTAURANT_1_MEALS_URL).basicAuth(USER)), RESTAURANT_1_MEALS);
    }

    @Test
    public void getAllAdmin() throws Exception {
        getAll(perform(doGet(RESTAURANT_2_MEALS_URL).basicAuth(ADMIN)), RESTAURANT_2_MEALS);
    }

    private void getAll(ResultActions resultActions, List<Meal> mealList) throws Exception {
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_TYPE))
                .andExpect(MEAL_MATCHERS.contentJson(mealList));
    }
}