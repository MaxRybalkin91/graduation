package ru.topjava.graduation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer> {

    @Query("select m from Meal m where m.restaurant.id = ?1 and m.date = ?2")
    List<Meal> findAllByIdAndDate(Integer id, LocalDate date);

    @Override
    @Transactional
    Meal save(Meal item);

    @Override
    @Transactional
    void deleteById(Integer id);
}