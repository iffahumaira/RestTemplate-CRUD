package com.resttemplatefood.service;

import com.resttemplatefood.model.Restaurant;
import com.resttemplatefood.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

//    @Override
//    public void createRestaurant(Restaurant restaurant) {
//        return restaurantRepository.save(restaurant);
//    }

    @Override
    public List<Restaurant> findAll() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findRestaurantById(Integer id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant res = restaurantRepository.findById(restaurant.getId()).get();
        res.setName(restaurant.getName());

        return restaurantRepository.save(res);
    }

    @Override
    public void deleteRestaurantById(Integer id) {
        restaurantRepository.deleteById(id);
    }


}
