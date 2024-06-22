package com.example.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class HealthClaimTest {

    @Mock
    private UserPolicy userPolicy;

    @InjectMocks
    private HealthClaim healthClaim;

    @BeforeEach
     void setUp() {
        healthClaim = new HealthClaim(1L, "Flu", LocalDateTime.now(), "General Hospital", "123 Main St",
                "Dr. Smith", "Bill123", "Pending", 2000.00, userPolicy);
    }

    @Test
     void testHealthClaimAttributes() {
        assertEquals(1L, healthClaim.getHealthClaimId());
        assertEquals("Flu", healthClaim.getDisease());
        assertNotNull(healthClaim.getDateofservice());
        assertEquals("General Hospital", healthClaim.getHospitalname());
        assertEquals("123 Main St", healthClaim.getAddress());
        assertEquals("Dr. Smith", healthClaim.getDoctorincharge());
        assertEquals("Bill123", healthClaim.getMedicalbill());
        assertEquals("Pending", healthClaim.getStatus());
        assertEquals(2000.00, healthClaim.getClaimamt());
        assertEquals(userPolicy, healthClaim.getUserPolicy());
    }

    @Test
     void testHealthClaimSetters() {
        LocalDateTime newDateOfService = LocalDateTime.now().plusDays(1);
        UserPolicy newUserPolicy = mock(UserPolicy.class);

        healthClaim.setHealthClaimId(2L);
        healthClaim.setDisease("Cold");
        healthClaim.setDateofservice(newDateOfService);
        healthClaim.setHospitalname("City Hospital");
        healthClaim.setAddress("456 Elm St");
        healthClaim.setDoctorincharge("Dr. Adams");
        healthClaim.setMedicalbill("Bill456");
        healthClaim.setStatus("Approved");
        healthClaim.setClaimamt(1500.00);
        healthClaim.setUserPolicy(newUserPolicy);

        assertEquals(2L, healthClaim.getHealthClaimId());
        assertEquals("Cold", healthClaim.getDisease());
        assertEquals(newDateOfService, healthClaim.getDateofservice());
        assertEquals("City Hospital", healthClaim.getHospitalname());
        assertEquals("456 Elm St", healthClaim.getAddress());
        assertEquals("Dr. Adams", healthClaim.getDoctorincharge());
        assertEquals("Bill456", healthClaim.getMedicalbill());
        assertEquals("Approved", healthClaim.getStatus());
        assertEquals(1500.00, healthClaim.getClaimamt());
        assertEquals(newUserPolicy, healthClaim.getUserPolicy());
    }

    @Test
     void testHealthClaimToString() {
        String expectedToString = "HealthClaim [healthClaimId=1, disease=Flu, dateofservice=" + healthClaim.getDateofservice() +
                ", hospitalname=General Hospital, address=123 Main St, doctorincharge=Dr. Smith, medicalbill=Bill123, " +
                "status=Pending, claimamt=2000.0, userPolicy=" + userPolicy + "]";
        assertEquals(expectedToString, healthClaim.toString());
    }
}

