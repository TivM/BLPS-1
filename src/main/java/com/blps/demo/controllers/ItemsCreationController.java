package com.blps.demo.controllers;

import com.blps.demo.entity.controllers.AddItemsRequest;
import com.blps.demo.entity.controllers.AddItemsResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsCreationController {

    @PostMapping(value = "/items/add")
    public @ResponseBody AddItemsResponse addItems(@RequestBody AddItemsRequest addItemsRequest) {
        return new AddItemsResponse(0, "OK", 0);
    }
}
