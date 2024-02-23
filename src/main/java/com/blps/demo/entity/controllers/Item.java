package com.blps.demo.entity.controllers;

import com.blps.demo.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record Item(String name, Integer count, Integer price, String category, Integer size) {
}


