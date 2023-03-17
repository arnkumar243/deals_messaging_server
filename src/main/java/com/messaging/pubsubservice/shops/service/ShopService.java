package com.messaging.pubsubservice.shops.service;

import com.messaging.pubsubservice.shops.entity.Shop;
import com.messaging.pubsubservice.shops.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Iterable<Shop> listShops() {
        return shopRepository.findAll();
    }

}
