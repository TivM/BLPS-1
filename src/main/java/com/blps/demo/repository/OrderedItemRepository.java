package com.blps.demo.repository;

import com.blps.demo.entity.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer> {
    void setStatusById(int id, String status);
}
