package com.example.controller;

import com.example.model.EmailRequest;

import com.example.model.AutoClaim;
import com.example.model.HealthClaim;
import com.example.model.Purchase;
import com.example.model.TermClaim;
import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return adminService.getAllUser();
    }

 @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable long userId) {
        return adminService.getUserById(userId);
        }
 

   @GetMapping("/admin")
    public User getAdmin() {
        return adminService.getAdmin();
    }

    @GetMapping("/active")
    public List<UserPolicy> getActiveUsers() {
        return adminService.getActiveUsers();
    }

    @GetMapping("/rejected")
    public List<User> getRejectedUsers() {
        return adminService.getRejectedUsers();
    }

    @GetMapping("/approved")
    public List<User> getApprovedUsers() {
        return adminService.getApprovedUsers();
    }

    @GetMapping("/search")
    public List<UserPolicy> searchUsers(@RequestParam("q") String searchTerm) {
        return adminService.searchUsers(searchTerm);
    }
    
    @GetMapping("/policydetails")
    public List<UserPolicy> getCustomerDetails() {
        return adminService.getCustomerDetails();
    }


    @PutMapping("/update/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User newUser) {
        adminService.updateUser(userId, newUser);
    }

    @GetMapping("/auto/claim")
    public List<AutoClaim> getAllAutoClaim() {
        return adminService.getAllAutoClaim();
    }

    @GetMapping("/health/claim")
    public List<HealthClaim> getAllHealthClaim() {
        return adminService.getAllHealthClaim();
    }

    @GetMapping("/term/claim")
    public List<TermClaim> getAllTermClaim() {
        return adminService.getAllTermClaim();
    }
    
    @GetMapping("/activeuserspermonth")
    public List<Map<String, Object>> countActiveUsersPerMonth() {
        return adminService.countActiveUsersPerMonth();
    }
    
    @GetMapping("/purchase/search")
    public List<Purchase> searchPurchases(@RequestParam("q") String searchTerm) {
        return adminService.searchPurchases(searchTerm);
    }

    
    
    @GetMapping("/allpurchase")
    public List<Purchase> getAllPurchase() {
        return adminService.getAllPurchase();
    }
    
    
    @PutMapping("/purchases/{purchaseId}")
  public ResponseEntity<String> updatePurchaseStatus(@PathVariable Long purchaseId, @RequestBody String status) {
      adminService.updatePurchaseStatus(purchaseId, status);
      return ResponseEntity.ok("Status updated successfully");
  }
    

    @PutMapping("/auto/status/{autoClaimId}")
    public void updateAutoClaimStatus(@PathVariable long autoClaimId , @RequestBody AutoClaim newClaim) {
    	adminService.updateAutoClaimStatus(autoClaimId, newClaim);
    }
    
    @PutMapping("/health/status/{healthClaimId}")
    public void updateHealthClaimStatus(@PathVariable long healthClaimId , @RequestBody HealthClaim newClaim) {
    	adminService.updateHealthClaimStatus(healthClaimId, newClaim);
    }
    
    @PutMapping("/term/status/{termClaimId}")
    public void updateTermClaimStatus(@PathVariable long termClaimId , @RequestBody TermClaim newClaim) {
    	adminService.updateTermClaimStatus(termClaimId, newClaim);
    }
    
    @GetMapping("/buyingrequest")
    public List<Purchase> buyingRequest() {
    	return adminService.buyingRequest();
    }
    
    @GetMapping("/auto/claimrequest")
    public List<AutoClaim> autoClaimRequest(){
    	return adminService.autoClaimRequest();
    }
    
    @GetMapping("/term/claimrequest")
    public List<TermClaim> termClaimRequest(){
    	return adminService.termClaimRequest();
    }
    
    @GetMapping("/health/claimrequest")
    public List<HealthClaim> healthClaimRequest(){
    	return adminService.healthClaimRequest();
    }
    

      @PostMapping("/send-email")
      public String sendEmail(@RequestBody EmailRequest emailRequest) {
          return adminService.sendEmail(emailRequest);
     }
    
    
    
    
}
