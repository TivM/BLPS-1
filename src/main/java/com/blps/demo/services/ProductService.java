package com.blps.demo.services;

import com.blps.demo.entity.Product;
import com.blps.demo.entity.Seller;
import com.blps.demo.entity.controllers.FindItemsRequest;

import java.util.List;
import java.util.Set;

public interface ProductService {
    int add(String name, int count, int price, String category, int size, Seller seller);

    List<Product> filter(FindItemsRequest findItemsRequest);
}
