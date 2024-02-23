package com.blps.demo.services;

import com.blps.demo.entity.OrderedItem;

import java.util.List;

public interface OrderedItemService {
    int add(int order_id, int product_id, String status);

    List<OrderedItem> getByOrderId(int order_id);
}
