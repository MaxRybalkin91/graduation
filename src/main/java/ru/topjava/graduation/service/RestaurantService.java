package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

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

    public Restaurant get(Integer id) {
        return restaurantRepository.getRestaurant(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public void update(Restaurant restaurant, Integer id) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }
}