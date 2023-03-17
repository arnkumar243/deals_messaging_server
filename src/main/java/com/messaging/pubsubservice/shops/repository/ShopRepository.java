package com.messaging.pubsubservice.shops.repository;

import com.messaging.pubsubservice.shops.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Integer> {
}
