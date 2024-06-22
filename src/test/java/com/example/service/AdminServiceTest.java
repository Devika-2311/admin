package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.repo.AutoClaimRepo;
import com.example.repo.HealthClaimRepo;
import com.example.repo.PurchaseRepo;
import com.example.repo.TermClaimRepo;
import com.example.repo.UserPolicyRepo;
import com.example.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
 class AdminServiceTest {

    @Mock
    private UserRepo userRepo;
    
    @Mock
    private AutoClaimRepo acr;
    
    @Mock
    private HealthClaimRepo hcr;
    
    @Mock
    private UserPolicyRepo upr;
    
    @Mock
    private PurchaseRepo pr;
    
    @Mock
    private TermClaimRepo tcr;
    
    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private AdminService adminService;


    @Test
    void testGetAllUser() {
        User user1 = new User();
        User user2 = new User();
        List<User> userList = Arrays.asList(user1, user2);
        
        when(userRepo.findAll()).thenReturn(userList);
        
        List<User> result = adminService.getAllUser();
        
        assertEquals(userList, result);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setUserId(1L);
        
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        
        Optional<User> result = adminService.getUserById(1L);
        
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testGetActiveUsers() {
        UserPolicy userPolicy1 = new UserPolicy();
        UserPolicy userPolicy2 = new UserPolicy();
        List<UserPolicy> activeUsers = Arrays.asList(userPolicy1, userPolicy2);
        
        when(upr.getActiveUsers()).thenReturn(activeUsers);
        
        List<UserPolicy> result = adminService.getActiveUsers();
        
        assertEquals(activeUsers, result);
    }

    @Test
    void testGetAdmin() {
        User admin = new User();
        
        when(userRepo.findAdmin()).thenReturn(admin);
        
        User result = adminService.getAdmin();
        
        assertEquals(admin, result);
    }

    @Test
    void testGetRejectedUsers() {
        User user1 = new User();
        User user2 = new User();
        List<User> rejectedUsers = Arrays.asList(user1, user2);
        
        when(userRepo.findRejectedUsers()).thenReturn(rejectedUsers);
        
        List<User> result = adminService.getRejectedUsers();
        
        assertEquals(rejectedUsers, result);
    }

    @Test
    void testGetApprovedUsers() {
        User user1 = new User();
        User user2 = new User();
        List<User> approvedUsers = Arrays.asList(user1, user2);
        
        when(userRepo.findApprovedUsers()).thenReturn(approvedUsers);
        
        List<User> result = adminService.getApprovedUsers();
        
        assertEquals(approvedUsers, result);
    }

    @Test
    void testGetCustomerDetails() {
        UserPolicy userPolicy1 = new UserPolicy();
        UserPolicy userPolicy2 = new UserPolicy();
        List<UserPolicy> customerDetails = Arrays.asList(userPolicy1, userPolicy2);
        
        when(upr.getCustomerDetails()).thenReturn(customerDetails);
        
        List<UserPolicy> result = adminService.getCustomerDetails();
        
        assertEquals(customerDetails, result);
    }
}
