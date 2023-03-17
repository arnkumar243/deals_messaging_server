package com.messaging.pubsubservice.health.controller;

import com.messaging.pubsubservice.health.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path="/api/health")
public class HealthController {

    @Autowired
    HealthService healthService;

    @GetMapping
    public Map<String, Object> getHealth() {
        return healthService.getHealth();
    }

}
