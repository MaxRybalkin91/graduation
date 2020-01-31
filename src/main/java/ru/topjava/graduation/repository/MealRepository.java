package ru.topjava.graduation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {

    @Override
    @Transactional
    Meal save(Meal item);

    @Transactional
    void deleteByIdAndRestaurantId(Integer id, Integer restaurantId);

    Optional<Meal> findByIdAndRestaurantId(Integer id, Integer restaurantId);

    List<Meal> findAllByRestaurantIdAndDateIsBefore(Integer restaurantId, LocalDate date);
}