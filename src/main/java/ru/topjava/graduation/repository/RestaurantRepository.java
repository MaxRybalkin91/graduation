package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>, JpaRepository<Restaurant, Integer> {

    List<Restaurant> findAllByUserId(Integer userId);

    @Override
    @Transactional
    Restaurant save(Restaurant item);

    @Transactional
    void deleteByIdAndUserId(Integer id, Integer userId);

    @Query("select distinct r from Restaurant r join fetch r.meals m where m.date=?1")
    List<Restaurant> findByRestaurantMealDate(LocalDate date);

    Optional<Restaurant> findByIdAndUserId(Integer id, Integer userId);

    /*@Modifying
    @Query("update Restaurant r set r.name = ?1, r.address = ?2 where r.id = ?3 and r.user.id = ?4")
    void setRestaurantByIdAndUserId(String name, String address, Integer id, Integer userId);*/
}