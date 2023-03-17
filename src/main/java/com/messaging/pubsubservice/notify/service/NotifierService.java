package com.messaging.pubsubservice.notify.service;

import com.messaging.pubsubservice.deals.entity.Deals;
import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.subscribers.service.SubscriberService;

import java.util.List;

public class NotifierService implements Runnable {

    SubscriberService subscriberService;

    EmailSender emailSender;

    Deals deal;

    public NotifierService(Deals deals, SubscriberService subscriberService, EmailSender emailSender) {
        this.deal = deals;
        this.subscriberService = subscriberService;
        this.emailSender = emailSender;
    }

    @Override
    public void run() {
        List<Subscriber> subscribers = subscriberService.getSubscriberByDeal(deal);

        for(Subscriber subscriber : subscribers) {

            String[] subscriberMail = {subscriber.getUser().getEmail()};
            String body = "A new deal has been published in " + deal.getShop().getName() +
                    " for the category " + deal.getCategory() + " on the occasion of " + deal.getFixedDeals().getName()
                    + ". " + deal.getDeal_info();

            emailSender.sendEmail(subscriberMail, null, body);
        }
    }

}
