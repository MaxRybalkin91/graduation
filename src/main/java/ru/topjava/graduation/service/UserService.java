package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Integer userId) {
        return userRepo.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void update(User user, Integer userId) {
        userRepo.getOne(userId);
        user.setRoles(Collections.emptySet());
        user.setId(userId);
        userRepo.save(user);
    }

    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.USER));
        return userRepo.save(user);
    }

    public void delete(Integer userId) {
        userRepo.deleteById(userId);
    }

    public void setActivity(Integer userId, boolean isActive) {
        User user = userRepo.getOne(userId);
        user.setEnabled(isActive);
        userRepo.save(user);
    }

    public void setOwner(Integer userId, boolean isOwner) {
        User user = userRepo.getOne(userId);
        user.setRoles(Collections.emptySet());
        user.setRoles(Set.of(isOwner ? Role.OWNER : Role.USER));
        userRepo.save(user);
    }
}