package com.messaging.pubsubservice.deals.controller;

import com.messaging.pubsubservice.deals.entity.Deals;
import com.messaging.pubsubservice.deals.service.DealsService;
import com.messaging.pubsubservice.fixed_deals.repository.FixedDealsRepository;
import com.messaging.pubsubservice.shops.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/deals")
public class DealsController {

    @Autowired
    private DealsService dealsService;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    FixedDealsRepository fixedDealsRepository;

    @PostMapping
    public Deals addNewDeal (@RequestBody Deals deal) {
        return dealsService.createDeal(deal);
    }

    @GetMapping(path="/{id}")
    public Deals getDealById(@PathVariable int id) {
        return dealsService.getDeal(id);
    }

    @GetMapping
    public Iterable<Deals> getAllDeals() {
        return dealsService.listAllDeals();
    }

}
