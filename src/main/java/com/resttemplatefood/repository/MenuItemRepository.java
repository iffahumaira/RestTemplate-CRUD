package com.resttemplatefood.repository;

import com.resttemplatefood.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    public List<MenuItem> findAllByRestaurantId(Integer id);
    public MenuItem findByName(@Param("name") String name);
}
