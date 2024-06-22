package com.example.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.model.EmailRequest;
import com.example.model.AutoClaim;
import com.example.model.Purchase;
import com.example.model.HealthClaim;
import com.example.model.TermClaim;
import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.repo.AutoClaimRepo;
import com.example.repo.HealthClaimRepo;
import com.example.repo.PurchaseRepo;
import com.example.repo.TermClaimRepo;
import com.example.repo.UserPolicyRepo;
import com.example.repo.UserRepo;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminService {


	    private final UserRepo userRepo;
	    private final AutoClaimRepo acr;
	    private final HealthClaimRepo hcr;
		private final UserPolicyRepo upr;
		private final PurchaseRepo pr;
		private final TermClaimRepo tcr;
		private final JavaMailSender javaMailSender;

	    public AdminService(UserRepo userRepo, AutoClaimRepo acr, HealthClaimRepo hcr, UserPolicyRepo upr, PurchaseRepo pr, TermClaimRepo tcr, JavaMailSender javaMailSender) {
	        this.userRepo = userRepo;
	        this.acr = acr;
	        this.hcr = hcr;
	        this.upr=upr;
	        this.pr=pr;
	        this.tcr=tcr;
	        this.javaMailSender=javaMailSender;
	        
	    }

	
	
	public String sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        javaMailSender.send(message);
        return "Email sent successfully";
    }
	
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	
    public Optional<User> getUserById(long userId) {
        return userRepo.findById(userId);
    }
    
    public List<UserPolicy> getActiveUsers()
	{
		return upr.getActiveUsers();
	}
    
    public User getAdmin() {
        return userRepo.findAdmin();
    }

    public List<User> getRejectedUsers() {
        return userRepo.findRejectedUsers();
    }

    public List<User> getApprovedUsers() {
        return userRepo.findApprovedUsers();
    }
    
    public List<UserPolicy> getCustomerDetails() {
        return upr.getCustomerDetails();
    }


    
    public List<UserPolicy> searchUsers(String searchTerm) {
        List<UserPolicy> activeUsers = getActiveUsers();

        // Filter users based on exact userId match
        return activeUsers.stream()
                .filter(userpolicy ->{
                    String userIdString = userpolicy.getUser().getUserId().toString().toLowerCase();
                    return userIdString.equals(searchTerm.toLowerCase()) || userpolicy.getUser().getFirstName().toLowerCase().contains(searchTerm); })
                .toList();
    }
    
    
    public List<Purchase> searchPurchases(String searchTerm) {
        List<Purchase> activePurchases = getAllPurchase();

        // Filter purchases based on exact purchaseId match
        return activePurchases.stream()
                .filter(purchase -> purchase.getUserPolicy().getUser().getUserId().toString().equals(searchTerm) ||
                 purchase.getUserPolicy().getUser().getFirstName().toLowerCase().contains(searchTerm))
                .toList();
    }
    
    public void updateUser(long userId, User newUser) {
        Optional<User> oldUser = userRepo.findById(userId);
        if (oldUser.isPresent()) {
            User existingUser = oldUser.get();
            existingUser.setFirstName(newUser.getFirstName());
            existingUser.setLastName(newUser.getLastName());
            existingUser.setAddress(newUser.getAddress());
            existingUser.setEmailId(newUser.getEmailId());
            existingUser.setPhoneNo(newUser.getPhoneNo());
            existingUser.setDob(newUser.getDob());
            userRepo.save(existingUser);
        }
    }
    
    
    public List<AutoClaim> getAllAutoClaim() {
        return acr.findAll();
    }

    public List<HealthClaim> getAllHealthClaim() {
        return hcr.findAll();
    }

    public List<TermClaim> getAllTermClaim() {
        return tcr.findAll();
    }
    
    public List<Map<String, Object>> countActiveUsersPerMonth() {
        return userRepo.countActiveUsersPerMonth();
    }
    
    public List<Purchase> getAllPurchase(){
    	return pr.findAll();
    }

    
    @Transactional
    public void updatePurchaseStatus(long purchaseId, String newStatus) {
    	newStatus = newStatus.replace("\"", "");
        Optional<Purchase> optionalPurchase = pr.findById(purchaseId);
        if (optionalPurchase.isPresent()) {
            Purchase purchase = optionalPurchase.get();
            UserPolicy userPolicy = purchase.getUserPolicy();
            if (userPolicy != null) {
                userPolicy.setStatus(newStatus);
                upr.save(userPolicy);
            }
        }
    }

    
    public void updateAutoClaimStatus(long autoClaimId , AutoClaim newClaim) {
        Optional<AutoClaim> oldClaim = acr.findById(autoClaimId);
        if (oldClaim.isPresent()) {
            AutoClaim existingClaim = oldClaim.get();
            existingClaim.setStatus(newClaim.getStatus());
            acr.save(existingClaim);
        }
    }
    
    public void updateHealthClaimStatus(long healthClaimId , HealthClaim newClaim) {
        Optional<HealthClaim> oldClaim = hcr.findById(healthClaimId);
        if (oldClaim.isPresent()) {
            HealthClaim existingClaim = oldClaim.get();
            existingClaim.setStatus(newClaim.getStatus());
            hcr.save(existingClaim);
        }
    }
    
    public void updateTermClaimStatus(long termClaimId , TermClaim newClaim) {
        Optional<TermClaim> oldClaim = tcr.findById(termClaimId);
        if (oldClaim.isPresent()) {
            TermClaim existingClaim = oldClaim.get();
            existingClaim.setStatus(newClaim.getStatus());
            tcr.save(existingClaim);
        }
    }
    
    public List<Purchase> buyingRequest() {
    	return pr.findPurchasesWithPendingUserPolicy();
    }
    
    public List<AutoClaim> autoClaimRequest(){
    	return acr.findclaimrequest();
    }
    
    public List<TermClaim> termClaimRequest(){
    	return tcr.findclaimrequest();
    }
    
    public List<HealthClaim> healthClaimRequest(){
    	return hcr.findclaimrequest();
    }

}
