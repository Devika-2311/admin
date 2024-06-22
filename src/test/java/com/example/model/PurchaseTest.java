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
 class PurchaseTest {

    @Mock
    private UserPolicy userPolicy;

    @InjectMocks
    private Purchase purchase;

    @BeforeEach
     void setUp() {
        // Initialize test data
        purchase = new Purchase(1L, userPolicy, PolicyType.TERM, 50000.0, "None", "John Doe", "Brother", "john@example.com", "ProofDoc", 30, 180.0, 75.0, true, false, "Normal", true, "None", "HealthReportDoc", "ModelX", "XYZ123", 20000.0, "Personal", "SUV", 35, "CheatSheet", LocalDate.now());
    }

    @Test
     void testPurchaseAttributes() {
        assertEquals(1L, purchase.getPolicyDetailsId());
        assertEquals(userPolicy, purchase.getUserPolicy());
        assertEquals(PolicyType.TERM, purchase.getPolicyType());
        assertEquals(50000.0, purchase.getAnnualIncome());
        assertEquals("None", purchase.getAnyDisease());
        assertEquals("John Doe", purchase.getNomineeName());
        assertEquals("Brother", purchase.getNomineeRelation());
        assertEquals("john@example.com", purchase.getNomineeEmail());
        assertEquals("ProofDoc", purchase.getNomineeProof());
        assertEquals(30, purchase.getAge());
        assertEquals(180.0, purchase.getHeight());
        assertEquals(75.0, purchase.getWeight());
        assertTrue(purchase.getSmoke());
        assertFalse(purchase.getAlcohol());
        assertEquals("Normal", purchase.getBp());
        assertTrue(purchase.getDiabetics());
        assertEquals("None", purchase.getCriticalDisease());
        assertEquals("HealthReportDoc", purchase.getHealthReport());
        assertEquals("ModelX", purchase.getVehicleModelNo());
        assertEquals("XYZ123", purchase.getLicensePlateNo());
        assertEquals(20000.0, purchase.getVehicleValue());
        assertEquals("Personal", purchase.getPrimaryUse());
        assertEquals("SUV", purchase.getVehicleType());
        assertEquals(35, purchase.getDriverAge());
        assertEquals("CheatSheet", purchase.getCheatSheet());
    }

    @Test
     void testPurchaseToString() {
        String expectedToString = "Purchase [policyDetailsId=1, userPolicy=" + userPolicy + ", policyType=TERM, annualIncome=50000.0, anyDisease=None, nomineeName=John Doe, nomineeRelation=Brother, nomineeEmail=john@example.com, nomineeProof=ProofDoc, age=30, height=180.0, weight=75.0, smoke=true, alcohol=false, bp=Normal, diabetics=true, criticalDisease=None, healthReport=HealthReportDoc, vehicleModelNo=ModelX, licensePlateNo=XYZ123, vehicleValue=20000.0, primaryUse=Personal, vehicleType=SUV, driverAge=35, cheatSheet=CheatSheet, purchaseDate=" + LocalDate.now() + "]";
        assertEquals(expectedToString, purchase.toString());
    }

    @Test
     void testPurchaseSetters() {
        purchase.setPolicyDetailsId(2L);
        purchase.setUserPolicy(null);
        purchase.setPolicyType(PolicyType.HEALTH);
        purchase.setAnnualIncome(60000.0);
        purchase.setAnyDisease("Hypertension");
        purchase.setNomineeName("Jane Doe");
        purchase.setNomineeRelation("Sister");
        purchase.setNomineeEmail("jane@example.com");
        purchase.setNomineeProof("NewProofDoc");
        purchase.setAge(40);
        purchase.setHeight(170.0);
        purchase.setWeight(65.0);
        purchase.setSmoke(false);
        purchase.setAlcohol(true);
        purchase.setBp("High");
        purchase.setDiabetics(false);
        purchase.setCriticalDisease("Asthma");
        purchase.setHealthReport("NewHealthReportDoc");
        purchase.setVehicleModelNo("ModelY");
        purchase.setLicensePlateNo("ABC789");
        purchase.setVehicleValue(30000.0);
        purchase.setPrimaryUse("Commercial");
        purchase.setVehicleType("Truck");
        purchase.setDriverAge(40);
        purchase.setCheatSheet("NewCheatSheet");

        assertEquals(2L, purchase.getPolicyDetailsId());
        assertNull(purchase.getUserPolicy());
        assertEquals(PolicyType.HEALTH, purchase.getPolicyType());
        assertEquals(60000.0, purchase.getAnnualIncome());
        assertEquals("Hypertension", purchase.getAnyDisease());
        assertEquals("Jane Doe", purchase.getNomineeName());
        assertEquals("Sister", purchase.getNomineeRelation());
        assertEquals("jane@example.com", purchase.getNomineeEmail());
        assertEquals("NewProofDoc", purchase.getNomineeProof());
        assertEquals(40, purchase.getAge());
        assertEquals(170.0, purchase.getHeight());
        assertEquals(65.0, purchase.getWeight());
        assertFalse(purchase.getSmoke());
        assertTrue(purchase.getAlcohol());
        assertEquals("High", purchase.getBp());
        assertFalse(purchase.getDiabetics());
        assertEquals("Asthma", purchase.getCriticalDisease());
        assertEquals("NewHealthReportDoc", purchase.getHealthReport());
        assertEquals("ModelY", purchase.getVehicleModelNo());
        assertEquals("ABC789", purchase.getLicensePlateNo());
        assertEquals(30000.0, purchase.getVehicleValue());
        assertEquals("Commercial", purchase.getPrimaryUse());
        assertEquals("Truck", purchase.getVehicleType());
        assertEquals(40, purchase.getDriverAge());
        assertEquals("NewCheatSheet", purchase.getCheatSheet());
    }

}

