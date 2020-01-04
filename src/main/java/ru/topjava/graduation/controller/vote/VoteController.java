package ru.topjava.graduation.controller.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.model.Vote;
import ru.topjava.graduation.model.dto.VoteTo;
import ru.topjava.graduation.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String REST_URL = "/vote";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{restaurant}")
    public List<VoteTo> getAll(@PathVariable("restaurant") Integer id) {
        log.info("get all votes for restaurant {}", id);
        return voteService.findForRestaurant(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{vote}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("vote") Integer id,
                       @RequestParam User user) {
        log.info("delete vote {} of user {}", id, user.getId());
        voteService.deleteById(id);
    }

    @PostMapping("{restaurant}")
    public Vote vote(@PathVariable("restaurant") Restaurant restaurant,
                     @AuthenticationPrincipal User user) {
        log.info("add vote of user {} for restaurant {}", user.getId(), restaurant.getId());
        return voteService.vote(restaurant, user);
    }
}