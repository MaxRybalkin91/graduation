package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Restaurant;

import java.util.List;

public interface RestaurantRepo extends CrudRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);

    List<Restaurant> findByAddress(String address);

}
