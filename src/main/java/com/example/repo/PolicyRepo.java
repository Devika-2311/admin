package com.example.repo;

import com.example.model.Policy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepo extends JpaRepository<Policy, Long> {
}
