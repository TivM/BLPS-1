package com.blps.demo.services;

import com.blps.demo.entity.Product;

import java.util.Set;

public interface ProductService {
    int add(String name, int count, int price, String category, int size, int sellerId);

    Set<Product> filter(String name, int price, String category, int size);
}
