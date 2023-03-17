package com.messaging.pubsubservice.users.service;

import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.subscribers.service.SubscriberService;
import com.messaging.pubsubservice.users.entity.User;
import com.messaging.pubsubservice.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriberService subscriberService;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> listUser() {
        return userRepository.findAll();
    }

    public List<Subscriber> listSubscriberForUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(""));
        return subscriberService.listSubscriberForUser(user);
    }

}
