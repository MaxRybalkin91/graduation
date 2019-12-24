package ru.topjava.graduation.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.UserRepository;
import ru.topjava.graduation.util.ErrorMessageUtil;

import java.util.Map;

@RestController
public class ProfileController {

    @Autowired
    private ErrorMessageUtil messageUtil;

    @Autowired
    private UserRepository repository;

    @GetMapping("/registration")
    public String register() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        if (repository.findByName(user.getName()) != null) {
            model.put("message", messageUtil.getExistedUserName());
            return "registration";
        }

        user.setRoles(Role.ROLE_USER);
        repository.save(user);

        return "redirect:/login";
    }
}
