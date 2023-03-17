package com.messaging.pubsubservice.users.controller;

import com.messaging.pubsubservice.subscribers.entity.Subscriber;
import com.messaging.pubsubservice.subscribers.service.SubscriberService;
import com.messaging.pubsubservice.users.entity.User;
import com.messaging.pubsubservice.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping
    public @ResponseBody User addNewUser (@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.listUser();
    }

    @GetMapping(path="/user/{userId}/subscribers")
    public @ResponseBody List<Subscriber> listSubscribersForUser(@PathVariable Integer userId) {
        return userService.listSubscriberForUser(userId);
    }
}
