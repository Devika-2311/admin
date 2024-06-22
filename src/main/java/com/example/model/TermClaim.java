package com.example.model;
 
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class TermClaim {
	  public Long getTermClaimId() {
		return termClaimId;
	}

	public void setTermClaimId(Long termClaimId) {
		this.termClaimId = termClaimId;
	}

	public String getDeathProof() {
		return deathProof;
	}

	public void setDeathProof(String deathProof) {
		this.deathProof = deathProof;
	}

	public String getNomineeProof() {
		return nomineeProof;
	}

	public void setNomineeProof(String nomineeProof) {
		this.nomineeProof = nomineeProof;
	}

	public UserPolicy getUserPolicy() {
		return userPolicy;
	}

	public void setUserPolicy(UserPolicy userPolicy) {
		this.userPolicy = userPolicy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TermClaim [termClaimId=" + termClaimId + ", deathProof=" + deathProof + ", nomineeProof=" + nomineeProof
				+ ", userPolicy=" + userPolicy + ", status=" + status + "]";
	}

	public TermClaim(Long termClaimId, String deathProof, String nomineeProof, UserPolicy userPolicy, String status) {
		super();
		this.termClaimId = termClaimId;
		this.deathProof = deathProof;
		this.nomineeProof = nomineeProof;
		this.userPolicy = userPolicy;
		this.status = status;
	}

	public TermClaim() {
		super();
		
	}

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long termClaimId;
 
	    @Column(name = "death_proof")
	    private String deathProof;
 
	    @Column(name = "nominee_proof")
	    private String nomineeProof;
 
	    @OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_policy_id")
	    private UserPolicy userPolicy;
	    
	    private String status;
 
}
