package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
    User findByName(String name);

    List<User> findAllByRolesIs(Role role);

    List<User> findAllByRolesContains(Role role);
}
