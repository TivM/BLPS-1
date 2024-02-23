package com.blps.demo.services;

import com.blps.demo.entity.ProductOrder;

public interface ProductOrderService {
    ProductOrder getById(int orderId);

    ProductOrder getByClientId(int clientId);

    int add(String pickupPointAddress, Integer deliveryTime, Integer costOfDelivery, int clientId, int orderedItemsId);

    void setCostOfDelivery(int orderId, Integer costOfDelivery);

    void setDeliveryTime(int orderId, Integer deliveryTime);
}
