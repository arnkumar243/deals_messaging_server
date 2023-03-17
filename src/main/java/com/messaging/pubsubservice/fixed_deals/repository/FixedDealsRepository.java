package com.messaging.pubsubservice.fixed_deals.repository;

import com.messaging.pubsubservice.fixed_deals.entity.FixedDeals;
import org.springframework.data.repository.CrudRepository;

public interface FixedDealsRepository extends CrudRepository<FixedDeals, Integer>  {
}
