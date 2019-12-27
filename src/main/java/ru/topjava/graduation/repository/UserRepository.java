package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.topjava.graduation.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
