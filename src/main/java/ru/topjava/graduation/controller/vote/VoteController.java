package ru.topjava.graduation.controller.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.service.VoteService;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class VoteController {
    static final String REST_URL = "/votes";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @GetMapping("{restaurant}")
    public Integer votesCount(@PathVariable("restaurant") Integer restaurantId) {
        return voteService.votesCount(restaurantId);
    }

    @PostMapping
    public Vote vote(@RequestParam("restaurantId") Integer restaurantId,
                     @RequestParam("dateTime") String dateTime,
                     @AuthenticationPrincipal User user) {
        log.info("add vote of user {} for restaurant {}", user.getId(), restaurantId);
        return voteService.vote(user, dateTime);
    }
}