package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.topjava.graduation.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
