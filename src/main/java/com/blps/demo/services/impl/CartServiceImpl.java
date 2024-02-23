package com.blps.demo.services.impl;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.Product;
import com.blps.demo.repository.CartRepository;
import com.blps.demo.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    @Override
    public void add(int productId, int clientId, int count) {

    }

    @Override
    public List<Cart> getByClientId(int clientId) {
        return cartRepository.findByClientId(clientId);
    }
}
