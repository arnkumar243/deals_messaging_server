package com.messaging.pubsubservice.fixed_deals.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.messaging.pubsubservice.deals.entity.Deals;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fixed_deals")
public class FixedDeals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "fixedDeals", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Deals> deals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Deals> getDeals() {
        return deals;
    }

    public void setDeals(List<Deals> deals) {
        this.deals = deals;
    }
}
