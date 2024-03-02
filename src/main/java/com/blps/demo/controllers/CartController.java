package com.blps.demo.controllers;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.controllers.*;
import com.blps.demo.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping("/cart")
    public AddCartResponse addCart(@RequestBody AddCartRequest addCartRequest){
        Cart cart = cartService.add(addCartRequest.productId(), addCartRequest.clientId(), addCartRequest.count());
        return new AddCartResponse(cart.getProduct().getId(), cart.getCount());
    }

    @GetMapping("/cart/{clientId}")
    public ListGetCartResponse getCartByClientId(@PathVariable int clientId){
        var carts = cartService.getByClientId(clientId);
        var listCartResponses = new ArrayList<GetCartResponse>();
        for (var cart: carts) {
            listCartResponses.add(
                    new GetCartResponse(cart.getProduct().getId(), cart.getClient().getId(), cart.getCount())
            );
        }
        return new ListGetCartResponse(listCartResponses);
    }

    @DeleteMapping("/cart/{productId}/{clientId}/{count}")
    public void getCartByClientId(
            @PathVariable int productId,
            @PathVariable int clientId,
            @PathVariable int count
    ){
        cartService.deleteByProductIdAndClientId(productId, clientId, count);
    }
}

