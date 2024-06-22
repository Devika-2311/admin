package com.example.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.model.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase,Long>{
	
	@Query("SELECT p FROM Purchase p WHERE p.userPolicy.status = 'Pending'")
    List<Purchase> findPurchasesWithPendingUserPolicy();


}
