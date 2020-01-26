package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantTo> getAll() {
        return restaurantRepository.findAll()
                .stream()
                .map(RestaurantTo::new)
                .collect(Collectors.toList());
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public RestaurantTo get(Integer restaurantId) {
        return new RestaurantTo(getOrThrow(restaurantId));
    }

    public void delete(Integer restaurantId) {
        getOrThrow(restaurantId);
        restaurantRepository.deleteById(restaurantId);
    }

    private Restaurant getOrThrow(Integer restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
    }
}