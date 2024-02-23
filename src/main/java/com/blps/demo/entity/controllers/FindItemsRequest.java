package com.blps.demo.entity.controllers;

public record FindItemsRequest(String name, Integer minPrice, Integer maxPrice, String category, Integer minSize, Integer maxSize) {}
