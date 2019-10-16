package com.resttemplatefood.service;

import com.resttemplatefood.model.MenuItem;
import com.resttemplatefood.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService{

    MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Integer id) {
        return menuItemRepository.
                findAllByRestaurantId(id);
    }

    @Override
    public void createMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }
}
