package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    List<Restaurant> findAll();

    @Query("select distinct r from Restaurant r join fetch r.meals m where m.date=?1")
    List<Restaurant> findByRestaurantMealDate(LocalDate date);

    Optional<Restaurant> findById(Integer id);
}