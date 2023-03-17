package com.messaging.pubsubservice.subscribers.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.messaging.pubsubservice.fixed_deals.entity.FixedDeals;
import com.messaging.pubsubservice.shops.entity.Shop;
import com.messaging.pubsubservice.users.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name="subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="sub_shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name="sub_fixed_deals_id")
    @JsonProperty("fixed_deals")
    private FixedDeals fixedDeals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
