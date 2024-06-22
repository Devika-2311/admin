package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
	
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
	
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	
import com.example.model.AutoClaim;
import com.example.model.EmailRequest;
import com.example.model.HealthClaim;
import com.example.model.Purchase;
import com.example.model.TermClaim;
import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.service.AdminService;

	@ExtendWith(MockitoExtension.class)
	 class AdminControllerTest {

	    @Mock
	    private AdminService adminService;

	    @InjectMocks
	    private AdminController adminController;

	    @Test
	     void testGetAllUsers() {
	        User user1 = new User();
	        User user2 = new User();
	        List<User> userList = Arrays.asList(user1, user2);
	        
	        when(adminService.getAllUser()).thenReturn(userList);
	        
	        List<User> result = adminController.getAllUsers();
	        
	        assertEquals(userList, result);
	    }

	    @Test
	     void testGetUserById() {
	        User user = new User();
	        user.setUserId(1L);
	        
	        when(adminService.getUserById(anyLong())).thenReturn(Optional.of(user));
	        
	        Optional<User> result = adminController.getUserById(1L);
	        
	        assertEquals(user, result.get());
	    }

	    @Test
	     void testGetAdmin() {
	        User admin = new User();
	        
	        when(adminService.getAdmin()).thenReturn(admin);
	        
	        User result = adminController.getAdmin();
	        
	        assertEquals(admin, result);
	    }

	    @Test
	     void testGetActiveUsers() {
	        UserPolicy userPolicy1 = new UserPolicy();
	        UserPolicy userPolicy2 = new UserPolicy();
	        List<UserPolicy> activeUsers = Arrays.asList(userPolicy1, userPolicy2);
	        
	        when(adminService.getActiveUsers()).thenReturn(activeUsers);
	        
	        List<UserPolicy> result = adminController.getActiveUsers();
	        
	        assertEquals(activeUsers, result);
	    }

	    @Test
	     void testGetRejectedUsers() {
	        User user1 = new User();
	        User user2 = new User();
	        List<User> rejectedUsers = Arrays.asList(user1, user2);
	        
	        when(adminService.getRejectedUsers()).thenReturn(rejectedUsers);
	        
	        List<User> result = adminController.getRejectedUsers();
	        
	        assertEquals(rejectedUsers, result);
	    }

	    @Test
	     void testGetApprovedUsers() {
	        User user1 = new User();
	        User user2 = new User();
	        List<User> approvedUsers = Arrays.asList(user1, user2);
	        
	        when(adminService.getApprovedUsers()).thenReturn(approvedUsers);
	        
	        List<User> result = adminController.getApprovedUsers();
	        
	        assertEquals(approvedUsers, result);
	    }

	    @Test
	     void testSearchUsers() {
	        User user1 = new User();
	        user1.setUserId(1L);
	        user1.setFirstName("John");
	        
	        UserPolicy userPolicy1 = new UserPolicy();
	        userPolicy1.setUser(user1);
	        
	        List<UserPolicy> activeUsers = Arrays.asList(userPolicy1);
	        
	        when(adminService.searchUsers(anyString())).thenReturn(activeUsers);
	        
	        List<UserPolicy> result = adminController.searchUsers("John");
	        
	        assertEquals(activeUsers, result);
	    }

	    @Test
	     void testGetCustomerDetails() {
	        UserPolicy userPolicy1 = new UserPolicy();
	        UserPolicy userPolicy2 = new UserPolicy();
	        List<UserPolicy> customerDetails = Arrays.asList(userPolicy1, userPolicy2);
	        
	        when(adminService.getCustomerDetails()).thenReturn(customerDetails);
	        
	        List<UserPolicy> result = adminController.getCustomerDetails();
	        
	        assertEquals(customerDetails, result);
	    }

	    @Test
	     void testUpdateUser() {
	        User newUser = new User();
	        newUser.setFirstName("Jane");
	        
	        adminController.updateUser(1L, newUser);
	        
	        verify(adminService).updateUser(1L, newUser);
	    }

	    @Test
	     void testGetAllAutoClaim() {
	        AutoClaim autoClaim1 = new AutoClaim();
	        AutoClaim autoClaim2 = new AutoClaim();
	        List<AutoClaim> autoClaims = Arrays.asList(autoClaim1, autoClaim2);
	        
	        when(adminService.getAllAutoClaim()).thenReturn(autoClaims);
	        
	        List<AutoClaim> result = adminController.getAllAutoClaim();
	        
	        assertEquals(autoClaims, result);
	    }

	    @Test
	     void testGetAllHealthClaim() {
	        HealthClaim healthClaim1 = new HealthClaim();
	        HealthClaim healthClaim2 = new HealthClaim();
	        List<HealthClaim> healthClaims = Arrays.asList(healthClaim1, healthClaim2);
	        
	        when(adminService.getAllHealthClaim()).thenReturn(healthClaims);
	        
	        List<HealthClaim> result = adminController.getAllHealthClaim();
	        
	        assertEquals(healthClaims, result);
	    }

	    @Test
	     void testGetAllTermClaim() {
	        TermClaim termClaim1 = new TermClaim();
	        TermClaim termClaim2 = new TermClaim();
	        List<TermClaim> termClaims = Arrays.asList(termClaim1, termClaim2);
	        
	        when(adminService.getAllTermClaim()).thenReturn(termClaims);
	        
	        List<TermClaim> result = adminController.getAllTermClaim();
	        
	        assertEquals(termClaims, result);
	    }

	    @Test
	     void testCountActiveUsersPerMonth() {
	        Map<String, Object> result1 = Map.of("month", "January", "count", 10);
	        Map<String, Object> result2 = Map.of("month", "February", "count", 15);
	        List<Map<String, Object>> counts = Arrays.asList(result1, result2);
	        
	        when(adminService.countActiveUsersPerMonth()).thenReturn(counts);
	        
	        List<Map<String, Object>> result = adminController.countActiveUsersPerMonth();
	        
	        assertEquals(counts, result);
	    }

	    @Test
	     void testSearchPurchases() {
	        Purchase purchase1 = new Purchase();
	        Purchase purchase2 = new Purchase();
	        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);
	        
	        when(adminService.searchPurchases(anyString())).thenReturn(purchases);
	        
	        List<Purchase> result = adminController.searchPurchases("John");
	        
	        assertEquals(purchases, result);
	    }

	    @Test
	     void testGetAllPurchase() {
	        Purchase purchase1 = new Purchase();
	        Purchase purchase2 = new Purchase();
	        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);
	        
	        when(adminService.getAllPurchase()).thenReturn(purchases);
	        
	        List<Purchase> result = adminController.getAllPurchase();
	        
	        assertEquals(purchases, result);
	    }

	    @Test
	     void testUpdatePurchaseStatus() {
	        String status = "Approved";
	        
	        ResponseEntity<String> response = adminController.updatePurchaseStatus(1L, status);
	        
	        verify(adminService).updatePurchaseStatus(1L, status);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("Status updated successfully", response.getBody());
	    }

	    @Test
	     void testUpdateAutoClaimStatus() {
	        AutoClaim newClaim = new AutoClaim();
	        
	        adminController.updateAutoClaimStatus(1L, newClaim);
	        
	        verify(adminService).updateAutoClaimStatus(1L, newClaim);
	    }

	    @Test
	     void testUpdateHealthClaimStatus() {
	        HealthClaim newClaim = new HealthClaim();
	        
	        adminController.updateHealthClaimStatus(1L, newClaim);
	        
	        verify(adminService).updateHealthClaimStatus(1L, newClaim);
	    }

	    @Test
	     void testUpdateTermClaimStatus() {
	        TermClaim newClaim = new TermClaim();
	        
	        adminController.updateTermClaimStatus(1L, newClaim);
	        
	        verify(adminService).updateTermClaimStatus(1L, newClaim);
	    }

	    @Test
	     void testBuyingRequest() {
	        Purchase purchase1 = new Purchase();
	        Purchase purchase2 = new Purchase();
	        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);
	        
	        when(adminService.buyingRequest()).thenReturn(purchases);
	        
	        List<Purchase> result = adminController.buyingRequest();
	        
	        assertEquals(purchases, result);
	    }

	    @Test
	     void testAutoClaimRequest() {
	        AutoClaim autoClaim1 = new AutoClaim();
	        AutoClaim autoClaim2 = new AutoClaim();
	        List<AutoClaim> autoClaims = Arrays.asList(autoClaim1, autoClaim2);
	        
	        when(adminService.autoClaimRequest()).thenReturn(autoClaims);
	        
	        List<AutoClaim> result = adminController.autoClaimRequest();
	        
	        assertEquals(autoClaims, result);
	    }

	    @Test
	     void testTermClaimRequest() {
	        TermClaim termClaim1 = new TermClaim();
	        TermClaim termClaim2 = new TermClaim();
	        List<TermClaim> termClaims = Arrays.asList(termClaim1, termClaim2);
	        
	        when(adminService.termClaimRequest()).thenReturn(termClaims);
	        
	        List<TermClaim> result = adminController.termClaimRequest();
	        
	        assertEquals(termClaims, result);
	    }

	    @Test
	     void testHealthClaimRequest() {
	        HealthClaim healthClaim1 = new HealthClaim();
	        HealthClaim healthClaim2 = new HealthClaim();
	        List<HealthClaim> healthClaims = Arrays.asList(healthClaim1, healthClaim2);
	        
	        when(adminService.healthClaimRequest()).thenReturn(healthClaims);
	        
	        List<HealthClaim> result = adminController.healthClaimRequest();
	        
	        assertEquals(healthClaims, result);
	    }

	    @Test
	     void testSendEmail() {
	        EmailRequest emailRequest = new EmailRequest();
	        emailRequest.setTo("test@example.com");
	        emailRequest.setSubject("Test Subject");
	        emailRequest.setBody("Test Body");
	        
	        when(adminService.sendEmail(emailRequest)).thenReturn("Email sent successfully");
	        
	        String result = adminController.sendEmail(emailRequest);
	        
	        assertEquals("Email sent successfully", result);
	    }
	}
