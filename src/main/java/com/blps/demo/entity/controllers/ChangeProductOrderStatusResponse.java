package com.blps.demo.entity.controllers;

import java.util.List;

public record ChangeProductOrderStatusResponse(List<ItemWithStatus> items) {}
