package com.blps.demo.controllers;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.controllers.*;
import com.blps.demo.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping("/carts")
    public AddCartResponse addCart(@RequestBody AddCartRequest addCartRequest){
        Cart cart = cartService.add(addCartRequest.productId(), addCartRequest.clientId(), addCartRequest.count());
        return new AddCartResponse(cart.getProduct().getId(), cart.getCount());
    }
}
