package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Integer id);
}