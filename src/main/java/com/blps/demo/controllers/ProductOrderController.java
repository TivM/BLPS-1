package com.blps.demo.controllers;

import com.blps.demo.entity.ProductOrder;
import com.blps.demo.entity.controllers.AddOrderRequest;
import com.blps.demo.entity.controllers.AddOrderResponse;
import com.blps.demo.entity.controllers.AddOrderResponseItem;
import com.blps.demo.exception.ResourceNotFoundException;
import com.blps.demo.services.CartService;
import com.blps.demo.services.OrderedItemService;
import com.blps.demo.services.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class ProductOrderController {

    private final ProductOrderService productOrderService;
    private final OrderedItemService orderedItemService;
    private final CartService cartService;

    @PostMapping("/add")
    public AddOrderResponse addOrder(@RequestBody AddOrderRequest addOrderRequest){
        var carts = cartService.getByClientId(addOrderRequest.clientId());

        if(carts.isEmpty()){
            throw new ResourceNotFoundException("client has no products in the cart");
        }

        ProductOrder order = productOrderService.add(addOrderRequest.pickupPointAddress(), addOrderRequest.clientId());

        var responseItems = new ArrayList<AddOrderResponseItem>();
        for (var cart: carts) {
            var orderedItem = orderedItemService.add(order, cart.getProduct(), "initial", cart.getCount());
            responseItems.add(new AddOrderResponseItem(cart.getProduct().getName(), orderedItem.getStatus()));
        }
        return new AddOrderResponse(
                responseItems, order.getDeliveryTime(), order.getCostOfDelivery(), "cash"
        );

    }
}
