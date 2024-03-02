package com.blps.demo.entity.controllers;

import java.util.List;

public record GetOrderResponse(Integer orderId, Integer clientId, List<ItemWithStatus> items) {}
