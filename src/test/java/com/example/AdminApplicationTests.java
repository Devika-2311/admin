package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.AdminService;

@SpringBootTest
class AdminApplicationTests {

	@Autowired
    private AdminService adminService;
 
    @Test
    void contextLoads() {
        assertThat(adminService).isNotNull();
    }
}
