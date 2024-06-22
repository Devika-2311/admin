package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.HealthClaim;

public interface HealthClaimRepo extends JpaRepository<HealthClaim,Long>{
	
	@Query("SELECT u FROM HealthClaim u WHERE u.status = 'Pending'")
	List<HealthClaim> findclaimrequest();
	}
