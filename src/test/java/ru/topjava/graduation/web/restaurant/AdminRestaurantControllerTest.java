package ru.topjava.graduation.web.restaurant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.topjava.graduation.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.topjava.graduation.RestaurantTestData.RESTAURANT_1;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;
import static ru.topjava.graduation.web.Controller.RESTAURANTS_URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRestaurantControllerTest extends AbstractControllerTest {

    public AdminRestaurantControllerTest() {
        super(RESTAURANTS_URL);
    }

    @Test
    public void getRestaurant() throws Exception {
        perform(doGet(RESTAURANT_1.getId()).basicAuth(ADMIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_TYPE))
                .andReturn();

//        Assert.assertEquals(objectMapper.writeValueAsString(RESTAURANT_1), mvcResult.getResponse());
    }

    /*@Test
    public void getUnauthorized() throws Exception {
        mockMvc.perform(get("/restaurants/100003"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }*/
}