package com.altimetrik.bugtracker.employeemodule.service;

import com.altimetrik.bugtracker.employeemodule.bean.EmployeeBean;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public EmployeeBean save(EmployeeBean employeeBean);
    public EmployeeBean fetchById(Long employeeId);
}
