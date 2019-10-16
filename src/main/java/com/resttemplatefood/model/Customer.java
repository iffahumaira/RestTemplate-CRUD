package com.resttemplatefood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private int id;
    //private int orderId; //FK
    private String name;
    private String phoneNumber;

}
