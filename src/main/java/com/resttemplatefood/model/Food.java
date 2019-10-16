package com.resttemplatefood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private int id;
    private String menu;
    private String description;
    private int quantity;
    private double price;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(unique = true)
//    private Restaurant restaurant;
//
//    public Food(String menu, String description, int quantity, double price, Restaurant restaurant){
//        this.menu = menu;
//        this.description = description;
//        this.quantity = quantity;
//        this.price = price;
//        this.restaurant = restaurant;
//        this.restaurant.setFood(this);

}
