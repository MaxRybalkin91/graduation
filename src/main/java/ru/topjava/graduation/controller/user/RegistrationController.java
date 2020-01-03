package ru.topjava.graduation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.service.UserService;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

}