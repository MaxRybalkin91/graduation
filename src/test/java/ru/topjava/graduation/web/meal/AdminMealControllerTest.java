package ru.topjava.graduation.web.meal;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.web.AbstractControllerTest;

import static ru.topjava.graduation.data.MealTestData.*;
import static ru.topjava.graduation.data.UserTestData.ADMIN;
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
    public void getNotOwned() throws Exception {
        expectNotFound(perform(doGet(MEAL_4_ID).basicAuth(ADMIN)));
    }

    @Test
    public void create() throws Exception {
        createNew(getNewMeal(), MEAL_MATCHERS);
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void createExists() throws Exception {
        Meal duplicated = new Meal(MEAL_1.getName(), MEAL_1.getPrice());
        expectDuplicated(perform(doPost().jsonBody(duplicated).basicAuth(ADMIN)));
    }

    @Test
    public void createInvalid() throws Exception {
        expectInvalidEntity(perform(doPost().jsonBody(INVALID_MEAL).basicAuth(ADMIN)));
    }

    @Test
    public void delete() throws Exception {
        deleteAndCheck(MEAL_1_ID);
    }

    @Test
    public void deleteNotFound() throws Exception {
        expectNotFound(perform(doDelete(USER.getId()).basicAuth(ADMIN)));
    }

    @Test
    public void get() throws Exception {
        getOne(MEAL_1, MEAL_MATCHERS);
    }

    @Test
    public void getOld() throws Exception {
        expectEditDeny(perform(doGet(OLD_MEAL_ID).basicAuth(ADMIN)));
    }

    @Test
    public void deleteOld() throws Exception {
        expectEditDeny(perform(doDelete(OLD_MEAL_ID).basicAuth(ADMIN)));
    }

    @Test
    public void getNotFound() throws Exception {
        expectNotFound(perform(doGet(USER.getId()).basicAuth(ADMIN)));
    }

    @Test
    public void update() throws Exception {
        update(MEAL_1_ID, getUpdatedMeal(), MEAL_MATCHERS);
    }

    @Test
    public void updateInvalid() throws Exception {
        Meal updated = new Meal(INVALID_MEAL);
        updated.setId(MEAL_1_ID);
        expectInvalidEntity(perform(doPut(MEAL_1_ID).jsonBody(INVALID_MEAL).basicAuth(ADMIN)));
    }

    @Test
    public void updateNotOwned() throws Exception {
        expectInvalidSave(perform(doPut(MEAL_4_ID).jsonBody(MEAL_4).basicAuth(ADMIN)));
    }

    @Test
    public void getHistory() throws Exception {
        getAllEntities(ADMIN_REST_1_MEALS_URL + "/history", ADMIN, RESTAURANT_1_MEALS, MEAL_HISTORY_MATCHERS);
    }
}