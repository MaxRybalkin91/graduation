package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public void vote(Restaurant restaurant) {
        restaurant.setVotes(restaurant.getVotes() + 1);
    }

    public List<Restaurant> findAll() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }
}
