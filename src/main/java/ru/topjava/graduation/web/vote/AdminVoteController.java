package ru.topjava.graduation.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.dto.VoteToDate;
import ru.topjava.graduation.service.VoteService;
import ru.topjava.graduation.web.Controller;

import java.util.List;

import static ru.topjava.graduation.web.Controller.ADMIN_VOTES_URL;
import static ru.topjava.graduation.web.Controller.JSON_TYPE;

@RestController
@RequestMapping(value = ADMIN_VOTES_URL, produces = JSON_TYPE)
public class AdminVoteController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @GetMapping
    public List<VoteToDate> getVotesStatistic(@PathVariable Integer restaurantId,
                                              @AuthenticationPrincipal User user) {
        log.info("get votes statistic for restaurant {} of user {}", restaurantId, user.getId());
        return voteService.getVotesStatistic(restaurantId, user.getId());
    }
}