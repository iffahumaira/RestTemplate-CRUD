package com.resttemplatefood.controller;


import com.resttemplatefood.model.Food;
import com.resttemplatefood.model.MenuItem;
import com.resttemplatefood.model.Restaurant;
import com.resttemplatefood.service.MenuItemService;
import com.resttemplatefood.service.RestaurantService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class RestaurantController {

    RestTemplate restTemplate;
    RestaurantService restaurantService;
    MenuItemService menuItemService;

    public RestaurantController(RestTemplate restTemplate, RestaurantService restaurantService, MenuItemService menuItemService) {
        this.restTemplate = restTemplate;
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    //REST TEMPLATE FETCH FOODS

    @GetMapping("foods")
    public String getFoods(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/v1/food", HttpMethod.GET, entity, String.class).getBody();
    }

    @GetMapping("foods/{id}")
    public Food getFoodsById(@PathVariable("id") Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(headers);

        return restTemplate.exchange("http://localhost:8080/v1/food/" +id, HttpMethod.GET, entity, Food.class).getBody();
    }

    @PostMapping("foods")
    public Food addFood(@RequestBody Food food) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(food,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food", HttpMethod.POST, entity, Food.class).getBody();
    }

    @PutMapping("foods")
    public Food updateFood(@RequestBody Food product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Food> entity = new HttpEntity<Food>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food", HttpMethod.PUT, entity, Food.class).getBody();
    }

    @DeleteMapping("foods/{id}")
    public String deleteFood(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<Integer>(id, headers);

        return restTemplate.exchange(
                "http://localhost:8080/v1/food/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    //RESTAURANT

    @GetMapping("restaurants")
    public List<Restaurant> findAll (){
        return restaurantService.findAll();
    }

    @PostMapping("restaurants")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("restaurants/{id}")
    public Restaurant findById (@PathVariable("id") Integer id){
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping("restaurants")
    @ResponseBody
    public Restaurant updateRestaurant (@RequestBody Restaurant restaurant){
        Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);
        return updateRestaurant;
    }

    @DeleteMapping("restaurants/{id}")
    @ResponseBody
    public void deleteRestaurantById(@PathVariable("id") Integer id){
        restaurantService.deleteRestaurantById(id);
    }

    //MENU ITEM

    @RequestMapping(value = "/restaurants/{id}/menuItems", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
    }



}
