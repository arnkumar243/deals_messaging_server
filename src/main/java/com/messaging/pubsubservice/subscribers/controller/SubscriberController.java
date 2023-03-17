package com.messaging.pubsubservice.subscribers.controller;

import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.subscribers.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="subscriber")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @PostMapping
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.addSubscriber(subscriber);
    }

    @GetMapping(path="/{id}")
    public Subscriber getSubscriber(@PathVariable Integer id) {
        return subscriberService.getSubscriberById(id);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable Integer id) {
        subscriberService.deleteSubscriber(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public Iterable<Subscriber> listSubscribers() {
        return subscriberService.listSubscribers();
    }

}
