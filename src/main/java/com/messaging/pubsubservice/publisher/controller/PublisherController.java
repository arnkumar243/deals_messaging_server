package com.messaging.pubsubservice.publisher.controller;

import com.messaging.pubsubservice.deals.entity.Deals;
import com.messaging.pubsubservice.publisher.service.PublisherService;
import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/publisher")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping(path = "/publish")
    public Deals publish(@RequestBody Deals deal) {
        return publisherService.publish(deal);
    }

    @PostMapping(path = "/subscribe")
    public Subscriber subscribe(@RequestBody Subscriber subscriber) {
        return publisherService.subscribe(subscriber);
    }

    @PostMapping(path = "/unsubscribe/{id}")
    public void unsubscribe(@PathVariable int id) {
        publisherService.unsubscribe(id);
    }

}
