package ru.topjava.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.UserService;
import ru.topjava.graduation.web.Controller;

import javax.validation.Valid;
import java.net.URI;

import static ru.topjava.graduation.web.Controller.JSON_TYPE;

@RestController
@RequestMapping(produces = JSON_TYPE)
public class ProfileController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping(value = REGISTER_URL, consumes = JSON_TYPE)
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        log.info("creating new user");
        User created = userService.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(RESTAURANTS_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = PROFILE_URL)
    public User get(Integer userId) {
        log.info("get user with id {}", userId);
        return userService.getUser(userId);
    }

    @PutMapping(value = PROFILE_URL)
    public void update(User user, Integer userId) {
        log.info("update user with id {}", userId);
        userService.update(user, userId);
    }
}
