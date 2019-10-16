package com.resttemplatefood.service;

import com.resttemplatefood.model.MenuItem;

import java.util.List;

public interface MenuItemService {

    List<MenuItem> findAllByRestaurantId(Integer id);
    void createMenuItem(MenuItem menuItem);
}
