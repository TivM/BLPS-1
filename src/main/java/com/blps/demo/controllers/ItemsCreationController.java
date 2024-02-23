package com.blps.demo.controllers;

import com.blps.demo.entity.Product;
import com.blps.demo.entity.controllers.*;
import com.blps.demo.services.ProductService;
import com.blps.demo.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsCreationController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

    @PostMapping(value = "/items/add")
    public @ResponseBody AddItemsResponse addItems(@RequestBody AddItemsRequest addItemsRequest) {
        var seller = addItemsRequest.sellerId() != null
                ? sellerService.getById(addItemsRequest.sellerId())
                : addItemsRequest.sellerName() != null
                    ? sellerService.getByName(addItemsRequest.sellerName())
                    : null;

        if (seller == null) {
            return new AddItemsResponse(0, "Невозможно идентифицировать продавца по переданным данным", -1);
        }


        var items = addItemsRequest.items();
        for (var item : items) {
            productService.add(item.name(), item.count(), item.price(), item.category(), item.size(), seller);
        }
        return new AddItemsResponse(items.size(), "OK", 0);
    }

    @PostMapping(value = "/items")
    public @ResponseBody FindItemsResponse findItems(@RequestBody FindItemsRequest findItemsRequest) {
        var products = productService.filter(findItemsRequest);
        var items = products.stream().map(this::convertProductToItem).toList();
        return new FindItemsResponse(items);
    }

    private Item convertProductToItem(Product product) {
        return new Item(product.getName(), product.getCount(), product.getPrice(), product.getCategory(), product.getSize());
    }
}
