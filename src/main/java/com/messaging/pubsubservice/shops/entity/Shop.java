package com.messaging.pubsubservice.shops.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.messaging.pubsubservice.deals.entity.Deals;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String location;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
