package com.messaging.pubsubservice.deals.entity;

import com.messaging.pubsubservice.fixed_deals.entity.FixedDeals;
import com.messaging.pubsubservice.shops.entity.Shop;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Deals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name="fixed_deals_id")
    private FixedDeals fixedDeals;

    @Nullable
    private String deal_info;

    @Nullable
    private String category ;

    @Nullable
    private Date start_date;

    @Nullable
    private Date end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public FixedDeals getFixedDeals() {
        return fixedDeals;
    }

    public void setFixedDeals(FixedDeals fixedDeals) {
        this.fixedDeals = fixedDeals;
    }

    public String getDeal_info() {
        return deal_info;
    }

    public void setDeal_info(String deal_info) {
        this.deal_info = deal_info;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
