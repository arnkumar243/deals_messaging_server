package com.messaging.pubsubservice.users.repository;

import com.messaging.pubsubservice.users.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}