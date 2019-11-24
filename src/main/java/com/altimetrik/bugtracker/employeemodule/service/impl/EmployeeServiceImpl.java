package com.altimetrik.bugtracker.employeemodule.service.impl;

import com.altimetrik.bugtracker.employeemodule.bean.EmployeeBean;
import com.altimetrik.bugtracker.employeemodule.entity.Employee;
import com.altimetrik.bugtracker.employeemodule.repository.EmployeeRepository;
import com.altimetrik.bugtracker.employeemodule.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    Logger log  = LoggerFactory.getLogger(EmployeeServiceImpl.class);
@Autowired
EmployeeRepository employeeRepository;


    @Override
    @Transactional
    public EmployeeBean save(EmployeeBean employeeBean) {
        Employee employee =  new Employee();
        BeanUtils.copyProperties(employeeBean,employee);
        employeeBean.setEmployeeId(this.employeeRepository.save(employee).getEmployeeId());
        return employeeBean;
    }

    @Override
    public EmployeeBean fetchById(Long employeeId) {
      Optional<Employee> employee =  employeeRepository.findByEmployeeId(employeeId);
        log.info("employee Name : {} ",employee.get());
        EmployeeBean employeeBean =  new EmployeeBean();
        //projectBean.setProjectId(project.get().getProjectId());
       // projectBean.setProjectId(this.projectRepository.save(project).getProjectId());
        BeanUtils.copyProperties(employee,employeeBean);
        //Get the manager Details from the Project Id using User Service.
        return employeeBean;
    }
}
