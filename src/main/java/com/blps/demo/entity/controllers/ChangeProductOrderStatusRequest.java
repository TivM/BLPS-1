package com.blps.demo.entity.controllers;

import java.util.List;

public record ChangeProductOrderStatusRequest(Long orderId, List<ItemWithStatus> items) {}
