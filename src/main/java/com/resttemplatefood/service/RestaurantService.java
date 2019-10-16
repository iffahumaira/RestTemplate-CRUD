package com.resttemplatefood.service;

import com.resttemplatefood.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAll();

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant findRestaurantById (Integer id);

    Restaurant updateRestaurant (Restaurant restaurant);

    void deleteRestaurantById (Integer id);
}
