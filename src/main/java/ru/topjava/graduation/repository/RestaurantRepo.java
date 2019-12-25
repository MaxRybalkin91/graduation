package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import ru.topjava.graduation.model.Restaurant;

public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
}