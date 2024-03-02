package com.blps.demo.services;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.Client;
import com.blps.demo.entity.Product;
import com.blps.demo.entity.ProductOrder;

import java.util.List;
import java.util.Set;

public interface CartService {
    Cart add(int productId, int clientId, int count);

    List<Cart> getByClientId(int clientId);

    void deleteByProductIdAndClientId(int productId, int clientId, int count);
}
