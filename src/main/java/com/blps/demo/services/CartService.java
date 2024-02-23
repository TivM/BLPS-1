package com.blps.demo.services;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.Product;

import java.util.List;
import java.util.Set;

public interface CartService {
    void add(int productId, int clientId, int count);

    List<Cart> getByClientId(int clientId);
}
