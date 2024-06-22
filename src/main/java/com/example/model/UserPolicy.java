package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity

@Table(name = "user_policy", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"user_id", "policy_id"})
	})
public class UserPolicy {
    public Long getUserPolicyId() {
		return userPolicyId;
	}
	public void setUserPolicyId(Long userPolicyId) {
		this.userPolicyId = userPolicyId;
	}
	public float getCoverage() {
		return coverage;
	}
	public void setCoverage(float coverage) {
		this.coverage = coverage;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	public String getPremiumTerm() {
		return premiumTerm;
	}
	public void setPremiumTerm(String premiumTerm) {
		this.premiumTerm = premiumTerm;
	}
	public int getPremiumCount() {
		return premiumCount;
	}
	public void setPremiumCount(int premiumCount) {
		this.premiumCount = premiumCount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public UserPolicy() {
		super();
		
	}
	public UserPolicy(Long userPolicyId, float coverage, int term, float premium, String premiumTerm, int premiumCount,
			LocalDate startDate, LocalDate endDate, String status, User user, Policy policy) {
		super();
		this.userPolicyId = userPolicyId;
		this.coverage = coverage;
		this.term = term;
		this.premium = premium;
		this.premiumTerm = premiumTerm;
		this.premiumCount = premiumCount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.user = user;
		this.policy = policy;
	}
	@Override
	public String toString() {
		return "UserPolicy [userPolicyId=" + userPolicyId + ", coverage=" + coverage + ", term=" + term + ", premium="
				+ premium + ", premiumTerm=" + premiumTerm + ", premiumCount=" + premiumCount + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + ", user=" + user + ", policy=" + policy
				+ "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPolicyId;
    private float coverage;
    private int term;
    private float premium;
    private String premiumTerm;
    private int premiumCount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Name of the foreign key column in the UserPolicy table
    private User user; // Reference to the User entity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policyId") // Name of the foreign key column in the UserPolicy table
    private Policy policy; // Reference to the User entity

}