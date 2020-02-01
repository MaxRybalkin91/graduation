package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.User;
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

    public List<Restaurant> getAll(Integer userId) {
        return restaurantRepository.findAllByUserId(userId);
    }

    @Cacheable("restaurants")
    public List<RestaurantTo> getWithMenu() {
        return restaurantRepository.findByRestaurantMealDate(LocalDate.now())
                .stream()
                .map(RestaurantTo::new)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Integer restaurantId, Restaurant restaurant, User user) {
        getOrThrowException(restaurantId, user.getId());
        restaurant.setId(restaurantId);
        create(restaurant, user);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant create(Restaurant restaurant, User user) {
        restaurant.setUser(user);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant get(Integer restaurantId, Integer userId) {
        return getOrThrowException(restaurantId, userId);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(Integer restaurantId, Integer userId) {
        restaurantRepository.deleteByIdAndUserId(restaurantId, userId);
    }

    private Restaurant getOrThrowException(Integer restaurantId, Integer userId) {
        return restaurantRepository.findByIdAndUserId(restaurantId, userId).orElseThrow(NotFoundException::getNotFoundException);
    }
}