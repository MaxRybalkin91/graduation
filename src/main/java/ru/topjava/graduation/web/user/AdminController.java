package ru.topjava.graduation.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.service.UserService;

@RestController
public class AdminController {

    @Autowired
    private UserService service;
}
