package com.messaging.pubsubservice.deals.service;

import com.messaging.pubsubservice.deals.entity.Deals;
import com.messaging.pubsubservice.deals.repository.DealsRepository;
import com.messaging.pubsubservice.fixed_deals.entity.FixedDeals;
import com.messaging.pubsubservice.fixed_deals.repository.FixedDealsRepository;
import com.messaging.pubsubservice.shops.entity.Shop;
import com.messaging.pubsubservice.shops.repository.ShopRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealsService {

    @Autowired
    DealsRepository dealsRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    FixedDealsRepository fixedDealsRepository;

    public Deals createDeal(Deals deal) {

        Shop shop = shopRepository.findById(deal.getShop().getId())
                .orElseThrow(() -> new EntityNotFoundException("Shop not found with ID : " + deal.getShop().getId()));

        deal.setShop(shop);

        FixedDeals fixedDeals = fixedDealsRepository.findById(deal.getFixedDeals().getId())
                .orElseThrow(() -> new EntityNotFoundException("Fixed Deal not found with Id : " + deal.getFixedDeals().getId()));

        deal.setFixedDeals(fixedDeals);

        return dealsRepository.save(deal);
    }

    public Deals getDeal(int dealId) {

        return dealsRepository.findById(dealId).orElseThrow(() -> new EntityNotFoundException("Deal not found with Id : " + dealId));
    }

    public Iterable<Deals> listAllDeals() {
        return dealsRepository.findAll();
    }


}
