package com.ProjectEM.EMS.controller;

import com.ProjectEM.EMS.entity.Employee;
import com.ProjectEM.EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping({"/{id}"})
    public Employee getEmployeeById(@PathVariable Long id) throws Exception{
        return employeeService.getEmployeeById(id);
    }

    @PutMapping({"/{id}"})
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception{
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping({"/{id}"})
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
