package ru.topjava.graduation.web.meal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.service.MealService;
import ru.topjava.graduation.util.exception.NotFoundException;
import ru.topjava.graduation.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.TestUtil.readFromJson;
import static ru.topjava.graduation.TestUtil.readFromJsonMvcResult;
import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.RestaurantTestData.getNewRestaurant;
import static ru.topjava.graduation.data.UserTestData.ADMIN;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.web.Controller.ADMIN_MEALS_URL;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

public class AdminMealControllerTest extends AbstractControllerTest {

    @Autowired
    private MealService mealService;

    public AdminMealControllerTest() {
        super(ADMIN_MEALS_URL);
    }

    @Test
    public void create() throws Exception {
        Meal newMeal = getNewMeal();
        ResultActions action = perform(doPost().jsonBody(newMeal).basicAuth(ADMIN));

        Meal created = readFromJson(action, Meal.class);
        Integer newId = created.getId();
        newMeal.setId(newId);

        MEAL_MATCHERS.assertMatch(created, newMeal);
        MEAL_MATCHERS.assertMatch(mealService.get(newId), newMeal);
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
    @Transactional(propagation = Propagation.NEVER)
    public void createExists() throws Exception {
        Meal duplicated = new Meal(MEAL_1.getName(), MEAL_1.getPrice());
        perform(doPost().jsonBody(duplicated)
                .basicAuth(ADMIN))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void delete() throws Exception {
        Integer rest_id = MEAL_1.getId();
        perform(doDelete(rest_id).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> mealService.get(rest_id));
    }

    @Test
    public void deleteNotFound() throws Exception {
        Integer rest_id = USER.getId();
        perform(doDelete(rest_id).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteUnauthorized() throws Exception {
        expectUnauthorized(perform(doRestaurantsGet(MEAL_1.getId())));
    }

    @Test
    public void deleteNotAdmin() throws Exception {
        expectForbidden(perform(doDelete(MEAL_1.getId()).basicAuth(USER)));
    }

    @Test
    public void get() throws Exception {
        perform(doRestaurantsGet(MEAL_1.getId()).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_TYPE))
                .andExpect(result -> MEAL_MATCHERS.assertMatch(readFromJsonMvcResult(result, Meal.class), MEAL_1));
    }

    @Test
    public void getUnauthorized() throws Exception {
        expectUnauthorized(perform(doRestaurantsGet(MEAL_1.getId())));
    }

    @Test
    public void getNotAdmin() throws Exception {
        expectForbidden(perform(doRestaurantsGet(MEAL_1.getId()).basicAuth(USER)));
    }

    @Test
    public void getNotFound() throws Exception {
        perform(doRestaurantsGet(USER.getId()).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void update() throws Exception {
        Meal newUpdatedMeal = getUpdatedMeal();
        ResultActions action = perform(doPost().jsonBody(newUpdatedMeal).basicAuth(ADMIN));

        Meal updated = readFromJson(action, Meal.class);

        MEAL_MATCHERS.assertMatch(updated, newUpdatedMeal);
        MEAL_MATCHERS.assertMatch(mealService.get(updated.getId()), newUpdatedMeal);
    }
}