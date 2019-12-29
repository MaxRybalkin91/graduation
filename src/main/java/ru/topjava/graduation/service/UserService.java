package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public User addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb == null) {
            user.setRoles(Collections.singleton(Role.USER));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            sendActivationCode(user);
            userFromDb = userRepo.save(user);
        }
        return userFromDb;
    }

    public User activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        if (user != null) {
            user.setActivationCode(null);
            sendLoginAndPassword(user);
            return userRepo.save(user);
        }
        return null;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }

    public void updateProfile(User user, String password, String email) {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged && !StringUtils.isEmpty(email)) {
            user.setEmail(email);
            sendActivationCode(user);
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepo.save(user);
    }

    private void sendActivationCode(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String activationCode = UUID.randomUUID().toString();
            user.setActivationCode(activationCode);
            String message = String.format(
                    "Hello, "
                            + "%s! \n"
                            + "To activate your account click here: "
                            + " http://localhost:8080/activate/%s",
                    user.getUsername(),
                    activationCode
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    private void sendLoginAndPassword(User user) {
        String message = String.format(
                "You have successfully activated your account! "
                        + "Here is your settings:\n"
                        + "Login: " + "%s\n"
                        + "Password: " + "%s\n",
                user.getUsername(),
                user.getPassword()
        );

        mailSender.send(user.getEmail(), "Information of your account", message);
    }
}