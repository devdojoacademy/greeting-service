package com.devdojo.greeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdojo.greeting.repository.GreetingRepository;
import com.devdojo.greeting.model.Greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @Autowired
    private GreetingRepository repository;

    public List<Greeting> getAllGreetings() {
        LOGGER.info("Fetching all greetings");
        var result = repository.findAll();
        return result;
    }

    public Greeting getGreetingById(Long id) {
        LOGGER.info("Fetching greeting with id {}", id);
        return repository.findById(id).orElse(null);
    }

    public Greeting createGreeting(Greeting greeting) {
        LOGGER.info("Creating new greeting");
        return repository.save(greeting);
    }

    public Greeting updateGreeting(Greeting greeting) {
        LOGGER.info("Updating greeting with id {}", greeting.getId());
        return repository.save(greeting);
    }

    public void deleteGreeting(Long id) {
        LOGGER.info("Deleting greeting with id {}", id);
        repository.deleteById(id);
    }
}
