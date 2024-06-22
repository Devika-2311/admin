package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class TermClaimTest {

    @Mock
    private UserPolicy userPolicy;

    @InjectMocks
    private TermClaim termClaim;

    @BeforeEach
     void setUp() {
        // Initialize test data
        termClaim = new TermClaim(1L, "DeathProofDoc", "NomineeProofDoc", userPolicy, "Pending");
    }

    @Test
     void testTermClaimAttributes() {
        assertEquals(1L, termClaim.getTermClaimId());
        assertEquals("DeathProofDoc", termClaim.getDeathProof());
        assertEquals("NomineeProofDoc", termClaim.getNomineeProof());
        assertEquals(userPolicy, termClaim.getUserPolicy());
        assertEquals("Pending", termClaim.getStatus());
    }

    @Test
     void testTermClaimToString() {
        String expectedToString = "TermClaim [termClaimId=1, deathProof=DeathProofDoc, nomineeProof=NomineeProofDoc, userPolicy=" + userPolicy + ", status=Pending]";
        assertEquals(expectedToString, termClaim.toString());
    }

    @Test
     void testTermClaimSetters() {
        termClaim.setTermClaimId(2L);
        termClaim.setDeathProof("NewDeathProofDoc");
        termClaim.setNomineeProof("NewNomineeProofDoc");
        termClaim.setUserPolicy(null);
        termClaim.setStatus("Approved");

        assertEquals(2L, termClaim.getTermClaimId());
        assertEquals("NewDeathProofDoc", termClaim.getDeathProof());
        assertEquals("NewNomineeProofDoc", termClaim.getNomineeProof());
        assertNull(termClaim.getUserPolicy());
        assertEquals("Approved", termClaim.getStatus());
    }

    // Add more test cases as needed for custom methods, validations, etc.
}
