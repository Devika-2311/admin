package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class AutoClaimTest {

    @InjectMocks
    private AutoClaim autoClaim;

    private UserPolicy userPolicy;

    @BeforeEach
     void setUp() {
        userPolicy = new UserPolicy();  // Assuming UserPolicy has a no-args constructor

        autoClaim = new AutoClaim(1L, "Model X", "ABC1234", 50000.0, 5,
                LocalDateTime.of(2023, 6, 20, 10, 0),
                30, "Minor scratches", 2000.0, "photo.jpg",
                userPolicy, "Pending");
    }

    @Test
     void testAutoClaimAttributes() {
        assertEquals(1L, autoClaim.getAutoClaimId());
        assertEquals("Model X", autoClaim.getVehicleModelNo());
        assertEquals("ABC1234", autoClaim.getLicensePlateNo());
        assertEquals(50000.0, autoClaim.getExShowroomPrice());
        assertEquals(5, autoClaim.getVehicleAge());
        assertEquals(LocalDateTime.of(2023, 6, 20, 10, 0), autoClaim.getIncidentTime());
        assertEquals(30, autoClaim.getDriverAge());
        assertEquals("Minor scratches", autoClaim.getDamageDescription());
        assertEquals(2000.0, autoClaim.getDamageCost());
        assertEquals("photo.jpg", autoClaim.getPhotoOfDamage());
        assertEquals(userPolicy, autoClaim.getUserPolicy());
        assertEquals("Pending", autoClaim.getStatus());
    }

    @Test
     void testAutoClaimSetters() {
        UserPolicy newUserPolicy = new UserPolicy();  // Assuming UserPolicy has a no-args constructor

        autoClaim.setAutoClaimId(2L);
        autoClaim.setVehicleModelNo("Model Y");
        autoClaim.setLicensePlateNo("XYZ5678");
        autoClaim.setExShowroomPrice(60000.0);
        autoClaim.setVehicleAge(3);
        autoClaim.setIncidentTime(LocalDateTime.of(2024, 1, 1, 12, 0));
        autoClaim.setDriverAge(25);
        autoClaim.setDamageDescription("Major dents");
        autoClaim.setDamageCost(3000.0);
        autoClaim.setPhotoOfDamage("new_photo.jpg");
        autoClaim.setUserPolicy(newUserPolicy);
        autoClaim.setStatus("Approved");

        assertEquals(2L, autoClaim.getAutoClaimId());
        assertEquals("Model Y", autoClaim.getVehicleModelNo());
        assertEquals("XYZ5678", autoClaim.getLicensePlateNo());
        assertEquals(60000.0, autoClaim.getExShowroomPrice());
        assertEquals(3, autoClaim.getVehicleAge());
        assertEquals(LocalDateTime.of(2024, 1, 1, 12, 0), autoClaim.getIncidentTime());
        assertEquals(25, autoClaim.getDriverAge());
        assertEquals("Major dents", autoClaim.getDamageDescription());
        assertEquals(3000.0, autoClaim.getDamageCost());
        assertEquals("new_photo.jpg", autoClaim.getPhotoOfDamage());
        assertEquals(newUserPolicy, autoClaim.getUserPolicy());
        assertEquals("Approved", autoClaim.getStatus());
    }

    @Test
     void testAutoClaimToString() {
        String expectedToString = "AutoClaim [autoClaimId=1, vehicleModelNo=Model X, licensePlateNo=ABC1234, exShowroomPrice=50000.0, vehicleAge=5, incidentTime=2023-06-20T10:00, driverAge=30, damageDescription=Minor scratches, damageCost=2000.0, photoOfDamage=photo.jpg, userPolicy=" + userPolicy + ", status=Pending]";
        assertEquals(expectedToString, autoClaim.toString());
    }
}

