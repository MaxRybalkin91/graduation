package ru.topjava.graduation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }
}
