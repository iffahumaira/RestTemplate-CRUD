package com.resttemplatefood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private int foodId;
    private String description;
    private int totalQuantity;
    private double price;
}
