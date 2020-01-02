package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant findById(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Integer id) {
        restaurantRepository.deleteById(id);
    }
}