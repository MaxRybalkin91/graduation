package ru.topjava.graduation.web.vote;

import org.junit.Assert;
import org.junit.Test;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.web.AbstractControllerTest;

import static ru.topjava.graduation.data.UserTestData.OWNER_1;
import static ru.topjava.graduation.data.UserTestData.USER;
import static ru.topjava.graduation.data.VoteTestData.*;

public class VoteControllerTest extends AbstractControllerTest {

    public VoteControllerTest() {
        super(REST_1_VOTES_URL);
    }

    @Test
    public void getAllForUnauthorized() throws Exception {
        expectUnauthorized(perform(doGet()));
    }

    @Test
    public void createUserVote() throws Exception {
        perform(doPut().basicAuth(USER));
        getVotes(USER, REST_1_VOTES + 1);
    }

    @Test
    public void getAllForUser() throws Exception {
        getVotes(USER, REST_1_VOTES);
    }

    @Test
    public void getAllForAdmin() throws Exception {
        getVotes(OWNER_1, REST_2_VOTES);
    }

    private void getVotes(User user, Integer votes) throws Exception {
        Integer expectedVotes = Integer.parseInt(perform(doGet().basicAuth(user))
                .andReturn()
                .getResponse()
                .getContentAsString());
        Assert.assertEquals(expectedVotes, votes);
    }
}