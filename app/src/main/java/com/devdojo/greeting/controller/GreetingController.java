package com.devdojo.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devdojo.greeting.model.Greeting;
import com.devdojo.greeting.service.GreetingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/greeting")
@CrossOrigin(origins = "*")
public class GreetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private GreetingService service;

    @GetMapping
    public List<Greeting> getAllGreetings() {
        LOGGER.info("Received request to fetch all greetings");
        return service.getAllGreetings();
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        LOGGER.info("Received request to fetch greeting with id {}", id);
        return service.getGreetingById(id);
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        LOGGER.info("Received request to create new greeting");
        return service.createGreeting(greeting);
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        LOGGER.info("Received request to update greeting with id {}", id);
        greeting.setId(id);
        return service.updateGreeting(greeting);
    }

    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        LOGGER.info("Received request to delete greeting with id {}", id);
        service.deleteGreeting(id);
    }
}