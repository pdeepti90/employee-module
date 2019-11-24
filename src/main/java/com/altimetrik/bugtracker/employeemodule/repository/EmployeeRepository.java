package com.altimetrik.bugtracker.employeemodule.repository;

import com.altimetrik.bugtracker.employeemodule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmployeeId(Long employeeId);
}
