package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.model.UserPolicy;

public interface UserPolicyRepo extends JpaRepository<UserPolicy,Long> {
	
	@Query("SELECT up FROM UserPolicy up JOIN User u ON up.user.userId = u.userId")
    List<UserPolicy> getCustomerDetails();
	
	@Query("SELECT up FROM UserPolicy up WHERE CURRENT_DATE < up.endDate AND up.status = 'Approved'")
	List<UserPolicy> getActiveUsers();

	
	

}