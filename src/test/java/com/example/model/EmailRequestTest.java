package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class EmailRequestTest {

    @InjectMocks
    private EmailRequest emailRequest;

    @BeforeEach
     void setUp() {
        emailRequest = new EmailRequest("test@example.com", "Test Subject", "Test Body");
    }

    @Test
     void testEmailRequestAttributes() {
        assertEquals("test@example.com", emailRequest.getTo());
        assertEquals("Test Subject", emailRequest.getSubject());
        assertEquals("Test Body", emailRequest.getBody());
    }

    @Test
     void testEmailRequestSetters() {
        emailRequest.setTo("new@example.com");
        emailRequest.setSubject("New Subject");
        emailRequest.setBody("New Body");

        assertEquals("new@example.com", emailRequest.getTo());
        assertEquals("New Subject", emailRequest.getSubject());
        assertEquals("New Body", emailRequest.getBody());
    }

    @Test
     void testEmailRequestToString() {
        String expectedToString = "EmailRequest [to=test@example.com, subject=Test Subject, body=Test Body]";
        assertEquals(expectedToString, emailRequest.toString());
    }
}

