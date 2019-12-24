package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findByAddress(String address);

    List<Restaurant> findByName(String name);
}