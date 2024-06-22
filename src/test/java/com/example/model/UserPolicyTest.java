package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class UserPolicyTest {

    @Mock
    private User user;

    @Mock
    private Policy policy;

    @InjectMocks
    private UserPolicy userPolicy;

    @BeforeEach
     void setUp() {
        // Initialize test data
        userPolicy = new UserPolicy(1L, 100000.0f, 20, 5000.0f, "Annual", 20, 
                                     LocalDate.of(2020, 1, 1), LocalDate.of(2040, 1, 1), "Active", user, policy);
    }

    @Test
     void testUserPolicyAttributes() {
        assertEquals(1L, userPolicy.getUserPolicyId());
        assertEquals(100000.0f, userPolicy.getCoverage());
        assertEquals(20, userPolicy.getTerm());
        assertEquals(5000.0f, userPolicy.getPremium());
        assertEquals("Annual", userPolicy.getPremiumTerm());
        assertEquals(20, userPolicy.getPremiumCount());
        assertEquals(LocalDate.of(2020, 1, 1), userPolicy.getStartDate());
        assertEquals(LocalDate.of(2040, 1, 1), userPolicy.getEndDate());
        assertEquals("Active", userPolicy.getStatus());
        assertEquals(user, userPolicy.getUser());
        assertEquals(policy, userPolicy.getPolicy());
    }

    @Test
     void testUserPolicyToString() {
        String expectedToString = "UserPolicy [userPolicyId=1, coverage=100000.0, term=20, premium=5000.0, premiumTerm=Annual, premiumCount=20, startDate=2020-01-01, endDate=2040-01-01, status=Active, user=" + user + ", policy=" + policy + "]";
        assertEquals(expectedToString, userPolicy.toString());
    }

    @Test
     void testUserPolicySetters() {
        userPolicy.setCoverage(200000.0f);
        userPolicy.setTerm(30);
        userPolicy.setPremium(6000.0f);
        userPolicy.setPremiumTerm("Monthly");
        userPolicy.setPremiumCount(30);
        userPolicy.setStartDate(LocalDate.of(2021, 1, 1));
        userPolicy.setEndDate(LocalDate.of(2051, 1, 1));
        userPolicy.setStatus("Inactive");
        userPolicy.setUser(null);
        userPolicy.setPolicy(null);

        assertEquals(200000.0f, userPolicy.getCoverage());
        assertEquals(30, userPolicy.getTerm());
        assertEquals(6000.0f, userPolicy.getPremium());
        assertEquals("Monthly", userPolicy.getPremiumTerm());
        assertEquals(30, userPolicy.getPremiumCount());
        assertEquals(LocalDate.of(2021, 1, 1), userPolicy.getStartDate());
        assertEquals(LocalDate.of(2051, 1, 1), userPolicy.getEndDate());
        assertEquals("Inactive", userPolicy.getStatus());
        assertNull(userPolicy.getUser());
        assertNull(userPolicy.getPolicy());
    }

    // Add more test cases as needed for custom methods, validations, etc.
}

