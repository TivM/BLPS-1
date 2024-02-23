package com.blps.demo.services.impl;

import com.blps.demo.entity.OrderedItem;
import com.blps.demo.entity.Product;
import com.blps.demo.entity.ProductOrder;
import com.blps.demo.repository.OrderedItemRepository;
import com.blps.demo.repository.ProductOrderRepository;
import com.blps.demo.repository.ProductRepository;
import com.blps.demo.services.OrderedItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedItemServiceImpl implements OrderedItemService {

    private final OrderedItemRepository orderedItemRepository;
    @Override
    public OrderedItem add(ProductOrder productOrder, Product product, String status) {

        OrderedItem orderedItem = new OrderedItem()
                .setStatus(status)
                .setProductOrder(productOrder)
                .setProduct(product);

        orderedItemRepository.save(orderedItem);

        return orderedItem;
    }

    @Override
    public List<OrderedItem> getByOrderId(int order_id) {
        return null;
    }
}
