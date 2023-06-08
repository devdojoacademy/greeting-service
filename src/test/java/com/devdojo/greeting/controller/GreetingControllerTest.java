package com.devdojo.greeting.controller;

import com.devdojo.greeting.model.Greeting;
import com.devdojo.greeting.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "logging.level.root=INFO",
        "logging.level.com.devdojo.greeting=INFO",
        "spring.datasource.url=jdbc:mysql://mysql_db:3306/greetingsdb",
        "spring.datasource.username=root",
        "spring.datasource.password=greetingdb"
})
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

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
    public void testGetAllGreetings() throws Exception {
        when(service.getAllGreetings()).thenReturn(Arrays.asList(greeting1, greeting2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/greeting")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"message\":\"Hello, World\"},{\"id\":2,\"message\":\"Goodbye, World\"}]"));
    }

    @Test
    public void testGetGreetingById() throws Exception {
        when(service.getGreetingById(1L)).thenReturn(greeting1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/greeting/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"message\":\"Hello, World\"}"));
    }

    @Test
    public void testCreateGreeting() throws Exception {
        Greeting newGreeting = new Greeting();
        newGreeting.setMessage("New Greeting");

        when(service.createGreeting(any(Greeting.class))).thenReturn(newGreeting);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/greeting")
                .content("{\"message\":\"New Greeting\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"New Greeting\"}"));
    }

    @Test
    public void testUpdateGreeting() throws Exception {
        greeting1.setMessage("Updated Greeting");

        when(service.updateGreeting(any(Greeting.class))).thenReturn(greeting1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/greeting/1")
                .content("{\"message\":\"Updated Greeting\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"message\":\"Updated Greeting\"}"));
    }

    @Test
    public void testDeleteGreeting() throws Exception {
        doNothing().when(service).deleteGreeting(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/greeting/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
