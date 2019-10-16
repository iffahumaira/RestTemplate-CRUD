package com.resttemplatefood.controller;

import com.resttemplatefood.service.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/")
public class MenuItemController {

    RestTemplate restTemplate;
    RestaurantService restaurantService;

    public MenuItemController(RestTemplate restTemplate, RestaurantService restaurantService) {
        this.restTemplate = restTemplate;
        this.restaurantService = restaurantService;
    }




}
