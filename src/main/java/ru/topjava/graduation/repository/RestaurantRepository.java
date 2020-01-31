package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>, JpaRepository<Restaurant, Integer> {

    List<Restaurant> findAll();

    @Override
    @Transactional
    Restaurant save(Restaurant item);

    @Override
    @Transactional
    void deleteById(Integer id);

    @Query("select distinct r from Restaurant r join fetch r.meals m where m.date=?1")
    List<Restaurant> findByRestaurantMealDate(LocalDate date);
}