package ru.topjava.graduation.controller.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.dto.VoteTo;
import ru.topjava.graduation.service.VoteService;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = AdminVoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminVoteController {
    static final String REST_URL = "/votes";

    @Autowired
    private VoteService voteService;

    @GetMapping("{restaurant}")
    public List<VoteTo> getAll(@PathVariable("restaurant") Integer id) {
        return voteService.findForRestaurant(id);
    }
}
