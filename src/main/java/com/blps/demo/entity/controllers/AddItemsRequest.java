package com.blps.demo.entity.controllers;

import java.util.List;

public record AddItemsRequest(Integer sellerId, String sellerName, List<Item> items) {}
record Item(Integer id, String name, Integer count, Integer price, String category, Integer size) {}
