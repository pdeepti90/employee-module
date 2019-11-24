package com.altimetrik.bugtracker.employeemodule.rest.resource;

import com.altimetrik.bugtracker.employeemodule.bean.EmployeeBean;
import com.altimetrik.bugtracker.employeemodule.exceptions.BadRequestAlertException;
import com.altimetrik.bugtracker.employeemodule.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    private final static String ENTITY_NAME = "ProjectResource";
    Logger log = LoggerFactory.getLogger(EmployeeResource.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeBean> createBug(@Valid @RequestBody EmployeeBean employeeBean) throws Exception {
        if (employeeBean.getEmployeeId() != null) {
            throw new BadRequestAlertException("A new Bug can not have already existing ID : " + ENTITY_NAME);
        }
        employeeBean = this.employeeService.save(employeeBean);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(employeeBean.getEmployeeId()).toUri();
        return ResponseEntity.created(location).body(employeeBean);
    }

   /* @PostMapping (path="/projects/search")
    public ResponseEntity<List<employeeBean>> searchBugs(@RequestBody employeeBean employeeBean){
        return null;
    }*/

    @GetMapping(path = "/employees")
    public ResponseEntity<EmployeeBean> fetchEmployee(@RequestParam(name="employeeId") Long employeeId) {
        log.info("employeeId : {}",employeeId);
        return ResponseEntity.ok().body(this.employeeService.fetchById(employeeId));
    }

    @GetMapping(path = "/employees/{projectId}")
    public ResponseEntity<List<EmployeeBean>> fetchAllEmployees(@PathVariable("projectId") Long projectId) {
        return null;
    }
}

