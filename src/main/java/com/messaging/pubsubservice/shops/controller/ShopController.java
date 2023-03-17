package com.messaging.pubsubservice.shops.controller;

import com.messaging.pubsubservice.shops.entity.Shop;
import com.messaging.pubsubservice.shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public @ResponseBody Shop addNewUser (@RequestBody Shop shop) {

        return shopService.createShop(shop);
    }

    @GetMapping
    public @ResponseBody Iterable<Shop> getAllShops() {
        return shopService.listShops();
    }

}
