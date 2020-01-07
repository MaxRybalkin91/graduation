package ru.topjava.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.dto.RestaurantTo;
import ru.topjava.graduation.repository.RestaurantRepository;
import ru.topjava.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static ru.topjava.graduation.util.RestaurantUtil.restaurantTos;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantTo> getForToday() {
        return restaurantTos(restaurantRepository.findByRestaurantMealDate(LocalDate.now()));
    }

    public Restaurant findById(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant get(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}