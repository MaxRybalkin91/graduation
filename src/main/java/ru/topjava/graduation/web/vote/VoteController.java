package ru.topjava.graduation.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.VoteService;
import ru.topjava.graduation.web.Controller;

import static ru.topjava.graduation.web.Controller.JSON_TYPE;
import static ru.topjava.graduation.web.Controller.VOTES_URL;

@RestController
@RequestMapping(value = VOTES_URL, produces = JSON_TYPE)
public class VoteController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @GetMapping
    public Integer getVotesCount(@PathVariable Integer restaurantId) {
        log.info("get count of the votes for restaurant {}", restaurantId);
        return voteService.getVotesCount(restaurantId);
    }

    @PutMapping
    public void create(@AuthenticationPrincipal User user,
                       @PathVariable Integer restaurantId) {
        log.info("user {} vote for restaurant {}", user.getId(), restaurantId);
        voteService.create(user, restaurantId);
    }
}