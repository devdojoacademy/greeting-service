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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        List<Greeting> result = service.getAllGreetings();

        assertEquals(2, result.size());
        assertEquals(greeting1, result.get(0));
        assertEquals(greeting2, result.get(1));
    }

    // Continue with other test cases...
}
