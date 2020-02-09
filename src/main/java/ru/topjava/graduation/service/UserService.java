package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;
import ru.topjava.graduation.repository.UserRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> getUsers() {
        return userRepo.findAllByRolesIs(Role.USER);
    }

    public List<User> getOwners() {
        return userRepo.findAllByRolesContains(Role.OWNER);
    }

    public User getUser(Integer userId) {
        return userRepo.findById(userId).orElseThrow(NotFoundException::getNotFoundException);
    }

    public void update(User user, Integer userId) {
        userRepo.getOne(userId);
        user.setRoles(Collections.emptySet());
        user.setId(userId);
        userRepo.save(user);
    }

    public User create(User user) {
        user.setRoles(Set.of(Role.USER));
        return userRepo.save(user);
    }

    public void setOwner(Integer userId, boolean isOwner) {
        User user = userRepo.getOne(userId);
        user.setRoles(Collections.emptySet());
        if (isOwner) {
            user.setRoles(Set.of(Role.USER, Role.OWNER));
        } else {
            user.setRoles(Set.of(Role.USER));
        }
        userRepo.save(user);
    }

    public void delete(Integer userId) {
        userRepo.deleteById(userId);
    }

    public void setActivity(Integer userId, boolean isActive) {
        User user = userRepo.getOne(userId);
        user.setEnabled(isActive);
        userRepo.save(user);
    }
}