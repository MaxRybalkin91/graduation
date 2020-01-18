package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.topjava.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("select distinct r from Restaurant r join fetch r.meals m where m.date=?1 and r.isEnabled=true")
    List<Restaurant> findByRestaurantMealDate(LocalDate date);
}