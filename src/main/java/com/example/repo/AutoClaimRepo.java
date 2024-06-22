package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.AutoClaim;

public interface AutoClaimRepo extends JpaRepository<AutoClaim,Long>
{
	@Query("SELECT u FROM AutoClaim u WHERE u.status = 'Pending'")
	List<AutoClaim> findclaimrequest();
	
	
	}
