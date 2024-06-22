package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.TermClaim;

public interface TermClaimRepo extends JpaRepository<TermClaim,Long>{
	
	@Query("SELECT u FROM TermClaim u WHERE u.status = 'Pending'")
	List<TermClaim> findclaimrequest();
	}
