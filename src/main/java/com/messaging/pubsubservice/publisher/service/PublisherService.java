package com.messaging.pubsubservice.publisher.service;

import com.messaging.pubsubservice.deals.entity.Deals;
import com.messaging.pubsubservice.deals.repository.DealsRepository;
import com.messaging.pubsubservice.deals.service.DealsService;
import com.messaging.pubsubservice.notify.service.EmailSender;
import com.messaging.pubsubservice.notify.service.NotifierService;
import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.subscribers.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    DealsRepository dealsRepository;

    @Autowired
    SubscriberService subscriberService;

    @Autowired
    EmailSender emailSender;

    public Deals publish(Deals deal) {

        System.out.println("Publishing new deal.");
        Deals deals = dealsRepository.save(deal);
        System.out.println("published new deal.");

        NotifierService notifierService = new NotifierService(deals, subscriberService, emailSender);
        Thread thread = new Thread(notifierService);

        thread.start();

        return deals;
    }

    public Subscriber subscribe(Subscriber subscriber) {
        return subscriberService.addSubscriber(subscriber);
    }

    public void unsubscribe(int subscriberId) {
        subscriberService.deleteSubscriber(subscriberId);
    }

}
