package com.blps.demo.services;

import com.blps.demo.entity.Product;

import java.util.Set;

public interface CartService {
    void add(int productId, int clientId, int count);

    Set<Product> getByClientId(int clientId);
}
