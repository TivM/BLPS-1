package com.blps.demo.controllers;

import com.blps.demo.entity.OrderedItem;
import com.blps.demo.entity.ProductOrder;
import com.blps.demo.entity.controllers.*;
import com.blps.demo.exception.ResourceNotFoundException;
import com.blps.demo.services.CartService;
import com.blps.demo.services.OrderedItemService;
import com.blps.demo.services.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    @PostMapping("/order/{id}/status")
    public ChangeProductOrderStatusResponse changeProductStatus(@PathVariable int id, @RequestBody ChangeProductOrderStatusRequest changeProductOrderStatusRequest){
        var productOrder = productOrderService.getById(id);

        if (productOrder == null) {
            throw new ResourceNotFoundException("Заказ с данным номером не существует");
        }

        var existingIds = orderedItemService.getByOrderId(productOrder.getId()).stream().map(OrderedItem::getId).collect(Collectors.toSet());
        var resultItems = new ArrayList<ItemWithStatus>();

        for (var item : changeProductOrderStatusRequest.items()) {
            if (existingIds.contains(item.id())) {
                var orderedItem = orderedItemService.setStatus(item.id(), item.status());
                resultItems.add(new ItemWithStatus(orderedItem.getId(), orderedItem.getStatus()));
            }
        }
        return new ChangeProductOrderStatusResponse(resultItems);
    }

}
