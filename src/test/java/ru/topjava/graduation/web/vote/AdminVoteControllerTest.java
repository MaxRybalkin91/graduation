package ru.topjava.graduation.web.vote;

import org.junit.Test;
import ru.topjava.graduation.web.AbstractControllerTest;

import static ru.topjava.graduation.data.UserTestData.ADMIN;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.data.VoteTestData.*;

public class AdminVoteControllerTest extends AbstractControllerTest {

    public AdminVoteControllerTest() {
        super(ADMIN_1_VOTES_URL);
    }

    @Test
    public void getStatistic() throws Exception {
        getAllEntities(null, ADMIN, VOTES_TO_RESTAURANT_1, VOTE_TO_MATCHERS);
    }

    @Test
    public void getUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet()));
    }

    @Test
    public void getNotAdmin() throws Exception {
        expectForbidden(perform(doGet().basicAuth(USER)));
    }
}