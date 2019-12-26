package ru.topjava.graduation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("message") String message) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
