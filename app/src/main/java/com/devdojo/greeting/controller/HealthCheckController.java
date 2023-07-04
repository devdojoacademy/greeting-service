package com.devdojo.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HealthCheckController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/healthcheck")
    public String healthCheck() {
        LOGGER.debug("Health check request");
        return "Service is running!";
    }
}