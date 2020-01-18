package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll() {
        return restaurantRepository.findByRestaurantMealDate(LocalDate.now());
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public RestaurantTo get(Integer id) {
        return new RestaurantTo(restaurantRepository.getOne(id));
    }

    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public void update(Restaurant restaurant, Integer id) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }
}