package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class PolicyTest {

    private Policy policy;

    @BeforeEach
     void setUp() {
        policy = new Policy(); // Assuming Policy has a no-args constructor
    }

    @Test
     void testPolicySetters() {
        policy.setPolicyId(2L);
        policy.setPolicyName("Auto Insurance Policy");
        policy.setPolicyDescription("Provides coverage for vehicle damages");
        policy.setTermsAndConditons("New terms and conditions apply");

        assertEquals(2L, policy.getPolicyId());
        assertEquals("Auto Insurance Policy", policy.getPolicyName());
        assertEquals("Provides coverage for vehicle damages", policy.getPolicyDescription());
        assertEquals("New terms and conditions apply", policy.getTermsAndConditons());
    }
}
