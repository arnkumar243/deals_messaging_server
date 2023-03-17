package com.messaging.pubsubservice.subscribers.repository;

import com.messaging.pubsubservice.fixed_deals.entity.FixedDeals;
import com.messaging.pubsubservice.shops.entity.Shop;
import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.users.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
	
	List<Subscriber> findByFixedDeals(FixedDeals fixedDeals);
	
	List<Subscriber> findByShop(Shop shop);

	List<Subscriber> findByUser(User user);
	
}
