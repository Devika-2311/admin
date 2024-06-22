package com.example.repo;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
	
    @Query("SELECT u FROM User u WHERE u.role = 'admin'")
    User findAdmin();

    @Query("SELECT up.user FROM UserPolicy up WHERE up.status = 'rejected'")
    List<User> findRejectedUsers();

    @Query("SELECT up.user FROM UserPolicy up WHERE up.status = 'approved'")
    List<User> findApprovedUsers();
    
    @Query(value = "SELECT DATE_FORMAT(created_at, '%Y-%m') as month, COUNT(*) as activeUsers " +
            "FROM user u JOIN user_policy up ON u.user_id = up.user_id " +
            "GROUP BY DATE_FORMAT(created_at, '%Y-%m') " +
            "ORDER BY month", nativeQuery = true)
List<Map<String, Object>> countActiveUsersPerMonth();
}