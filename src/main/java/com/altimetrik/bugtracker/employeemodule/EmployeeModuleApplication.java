package com.altimetrik.bugtracker.employeemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeModuleApplication.class, args);
	}

}
