package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public List<RestaurantTo> getWithMenu() {
        return restaurantRepository.findByRestaurantMealDate(LocalDate.now())
                .stream()
                .map(RestaurantTo::new)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Integer restaurantId, Restaurant restaurant) {
        restaurant.setId(restaurantId);
        restaurantRepository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant get(Integer restaurantId) {
        return getOrThrowException(restaurantId);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(Integer restaurantId) {
        getOrThrowException(restaurantId);
        restaurantRepository.deleteById(restaurantId);
    }

    private Restaurant getOrThrowException(Integer restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
    }
}