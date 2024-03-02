package com.blps.demo.entity.controllers;

import com.blps.demo.entity.OrderedItem;
import com.blps.demo.entity.ProductOrder;

import java.util.List;
import java.util.Set;

public record AddOrderResponse(Integer id, List<AddOrderResponseItem> items, Integer deliveryTime, Integer costOfDelivery, String paymentMethod) {

}
