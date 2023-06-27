package com.devdojo.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devdojo.greeting.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
