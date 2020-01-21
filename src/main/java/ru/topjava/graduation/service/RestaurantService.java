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

    public RestaurantTo get(Integer id) {
        return new RestaurantTo(restaurantRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }
}