package ru.topjava.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.service.UserService;
import ru.topjava.graduation.web.Controller;

import java.util.List;

import static ru.topjava.graduation.web.Controller.*;

@RestController
@RequestMapping(value = {USER_LIST_URL, OWNER_LIST_URL}, produces = JSON_TYPE)
public class AdminUserController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        log.info("get all users");
        return userService.getUsers();
    }

    @GetMapping
    public List<User> getOwners() {
        log.info("get all owners");
        return userService.getOwners();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/owner/{id}")
    public void setOwner(@PathVariable Integer id, @RequestParam Boolean isOwner) {
        userService.setOwner(id, isOwner);
    }

    @PutMapping("/active/{id}")
    public void setActive(@PathVariable Integer id, @RequestParam Boolean isActive) {
        userService.setActivity(id, isActive);
    }
}
