package ru.topjava.graduation.web.meal;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.web.AbstractControllerTest;

import java.time.LocalDate;

import static ru.topjava.graduation.TestUtil.readFromJson;
import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.UserTestData.ADMIN_1;
import static ru.topjava.graduation.data.UserTestData.USER;

public class AdminMealControllerTest extends AbstractControllerTest {

    public AdminMealControllerTest() {
        super(ADMIN_REST_1_MEALS_URL);
    }

    @Test
    public void createUnauthorized() throws Exception {
        expectUnauthorized(perform(doPost().jsonBody(getNewMeal())));
    }

    @Test
    public void createNotAdmin() throws Exception {
        expectForbidden(perform(doPost().jsonBody(getNewMeal()).basicAuth(USER)));
    }

    @Test
    public void deleteUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(MEAL_1_ID)));
    }

    @Test
    public void deleteNotAdmin() throws Exception {
        expectForbidden(perform(doDelete(MEAL_1_ID).basicAuth(USER)));
    }

    @Test
    public void getUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet(MEAL_1_ID)));
    }

    @Test
    public void getNotAdmin() throws Exception {
        expectForbidden(perform(doGet(MEAL_1_ID).basicAuth(USER)));
    }

    @Test
    public void getAlien() throws Exception {
        expectNotFound(perform(doGet(MEAL_4_ID).basicAuth(ADMIN_1)));
    }

    @Test
    public void create() throws Exception {
        createNew(getNewMeal(), MEAL_MATCHERS);
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void createExists() throws Exception {
        Meal duplicated = new Meal(MEAL_1.getName(), MEAL_1.getPrice());
        expectDuplicated(perform(doPost().jsonBody(duplicated).basicAuth(ADMIN_1)));
    }

    @Test
    public void createInvalid() throws Exception {
        expectInvalidEntity(perform(doPost().jsonBody(INVALID_MEAL).basicAuth(ADMIN_1)));
    }

    @Test
    public void delete() throws Exception {
        deleteAndCheck(MEAL_1_ID);
    }

    @Test
    public void get() throws Exception {
        getOne(MEAL_1, MEAL_MATCHERS);
    }

    @Test
    public void getOld() throws Exception {
        expectEditDeny(perform(doGet(OLD_MEAL_1_REST_1.getId()).basicAuth(ADMIN_1)));
    }

    @Test
    public void getNotFound() throws Exception {
        expectNotFound(perform(doGet(USER.getId()).basicAuth(ADMIN_1)));
    }

    @Test
    public void update() throws Exception {
        update(MEAL_1_ID, getUpdatedMeal(), MEAL_MATCHERS);
    }

    @Test
    public void updateInvalid() throws Exception {
        Meal updated = new Meal(INVALID_MEAL);
        updated.setId(MEAL_1_ID);
        expectInvalidEntity(perform(doPut(MEAL_1_ID).jsonBody(INVALID_MEAL).basicAuth(ADMIN_1)));
    }

    @Test
    public void updateAlien() throws Exception {
        expectNotFound(perform(doPut(MEAL_4_ID).jsonBody(MEAL_4).basicAuth(ADMIN_1)));
    }

    @Test
    public void getHistory() throws Exception {
        getAllEntities(ADMIN_REST_1_MEALS_URL + "/history", ADMIN_1, RESTAURANT_1_HISTORY, MEAL_MATCHERS);
    }

    @Test
    public void getFutureMeals() throws Exception {
        getAllEntities(ADMIN_REST_1_MEALS_URL + "/future", ADMIN_1, RESTAURANT_1_FUTURE_MEALS, MEAL_MATCHERS);
    }

    @Test
    public void getTodayMeals() throws Exception {
        getAllEntities(ADMIN_REST_1_MEALS_URL, ADMIN_1, RESTAURANT_1_TODAY_MEALS, MEAL_MATCHERS);
    }

    @Test
    public void getOneFuture() throws Exception {
        getOne(FUTURE_MEAL_1_REST_1, MEAL_MATCHERS);
    }

    @Test
    public void createForFuture() throws Exception {
        Meal newMeal = getNewMeal();
        newMeal.setDate(LocalDate.of(2020, 6, 15));
        ResultActions action = perform(doPost(ADMIN_REST_1_FUTURE_MEALS_URL).jsonBody(newMeal).basicAuth(ADMIN_1));
        getOne(readFromJson(action, Meal.class), MEAL_MATCHERS);
    }

    @Test
    public void updateWithSettingOldDate() throws Exception {
        Meal updated = getUpdatedMeal();
        updated.setDate(LocalDate.of(2015, 1, 1));
        expectOldDate(perform(doPut(MEAL_1_ID).jsonBody(updated).basicAuth(ADMIN_1)));
    }
}