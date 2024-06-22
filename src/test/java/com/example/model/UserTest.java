package com.example.model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
 class UserTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private User user;

    @BeforeEach
     void setUp() {
        // Initialize test data if needed
        user = new User(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "1234567890", "john.doe@example.com",
                "123 Main St, City", "password123", "user", LocalDate.now());
    }

    @Test
     void testUserAttributes() {
        assertEquals(1L, user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(LocalDate.of(1990, 1, 1), user.getDob());
        assertEquals("1234567890", user.getPhoneNo());
        assertEquals("john.doe@example.com", user.getEmailId());
        assertEquals("123 Main St, City", user.getAddress());
        assertEquals("password123", user.getPassword());
        assertEquals("user", user.getRole());
        assertEquals(LocalDate.now(), user.getCreatedAt());
    }

    @Test
     void testUserToString() {
        String expectedToString = "User [userId=1, firstName=John, lastName=Doe, dob=1990-01-01, phoneNo=1234567890, " +
                "emailId=john.doe@example.com, address=123 Main St, City, password=password123, role=user, createdAt=" +
                LocalDate.now() + "]";
        assertEquals(expectedToString, user.toString());
    }

    @Test
     void testSaveUser() {
        when(userRepo.save(user)).thenReturn(user); // Mocking repository save operation

        User savedUser = userRepo.save(user);
        assertNotNull(savedUser);
        assertEquals(user.getUserId(), savedUser.getUserId());
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        // Add more assertions as per your entity's attributes

        verify(userRepo, times(1)).save(user); // Verifying that save method was called exactly once
    }

    // Add more test cases as needed for custom methods, validations, etc.
}
