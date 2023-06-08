package com.devdojo.greeting.service;

import com.devdojo.greeting.model.Greeting;
import com.devdojo.greeting.repository.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {

    @InjectMocks
    private GreetingService service;

    @Mock
    private GreetingRepository repository;

    private Greeting greeting1;
    private Greeting greeting2;

    @BeforeEach
    public void setup() {
        greeting1 = new Greeting();
        greeting1.setId(1L);
        greeting1.setMessage("Hello, World");

        greeting2 = new Greeting();
        greeting2.setId(2L);
        greeting2.setMessage("Goodbye, World");
    }

    @Test
    public void testGetAllGreetings() {
        when(repository.findAll()).thenReturn(Arrays.asList(greeting1, greeting2));

        var result = service.getAllGreetings();

        assertEquals(2, result.size());
        assertEquals(greeting1, result.get(0));
        assertEquals(greeting2, result.get(1));
    }

    @Test
    public void testGetGreetingById() {
        when(repository.findById(greeting1.getId())).thenReturn(Optional.of(greeting1));

        var result = service.getGreetingById(greeting1.getId());

        assertNotNull(result);
        assertEquals(greeting1, result);
    }

    @Test
    public void testCreateGreeting() {
        when(repository.save(any(Greeting.class))).thenReturn(greeting1);

        var result = service.createGreeting(greeting1);

        assertNotNull(result);
        assertEquals(greeting1, result);
    }

    @Test
    public void testUpdateGreeting() {
        when(repository.save(any(Greeting.class))).thenReturn(greeting1);

        var result = service.updateGreeting(greeting1);

        assertNotNull(result);
        assertEquals(greeting1, result);
    }

    @Test
    public void testDeleteGreeting() {
        doNothing().when(repository).deleteById(greeting1.getId());

        service.deleteGreeting(greeting1.getId());

        verify(repository, times(1)).deleteById(greeting1.getId());
    }
}
