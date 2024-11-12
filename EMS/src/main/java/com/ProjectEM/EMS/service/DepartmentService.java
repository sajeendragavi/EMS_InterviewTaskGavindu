package com.ProjectEM.EMS.service;

import com.ProjectEM.EMS.entity.Department;
import com.ProjectEM.EMS.entity.Employee;
import com.ProjectEM.EMS.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not found"));
    }

    public Department updateDepartment(Long id, Department updatedDepartment){
        Department department = getDepartmentById(id);
        department.setName(updatedDepartment.getName());
        department.setEmployees(updatedDepartment.getEmployees());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
